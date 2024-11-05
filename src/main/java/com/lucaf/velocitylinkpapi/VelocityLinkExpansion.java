package com.lucaf.velocitylinkpapi;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import com.google.gson.Gson;
import me.clip.placeholderapi.expansion.Configurable;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.clip.placeholderapi.expansion.Taskable;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.io.DataInputStream;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

public final class VelocityLinkExpansion extends PlaceholderExpansion implements PluginMessageListener, Taskable {
    @Override
    public @NotNull String getIdentifier() {
        return "velocitylink";
    }

    @Override
    public @NotNull String getAuthor() {
        return "LucaFontanot";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    final HashMap<String, String> placeholdersCache = new HashMap<>();

    private final AtomicReference<BukkitTask> cached = new AtomicReference<>();

    public static final String CHANNEL = "velocitylink:channel";

    public void sendChannelMessage(String message){
        Bukkit.getServer().sendPluginMessage(getPlaceholderAPI(), CHANNEL, message.getBytes());
    }

    @Override
    public void start() {
        final BukkitTask task = Bukkit.getScheduler().runTaskTimer(getPlaceholderAPI(), () -> {
            for (String placeholder : placeholdersCache.keySet()) {
                PluginMessageData pluginMessageData = new PluginMessageData();
                pluginMessageData.setType("getPlaceholder");
                pluginMessageData.setSendData(placeholder);
                sendChannelMessage(new Gson().toJson(pluginMessageData));
            }
        }, 20L * 2L, 20L * 10);


        final BukkitTask prev = cached.getAndSet(task);
        if (prev != null) {
            prev.cancel();
        } else {
            Bukkit.getMessenger().registerOutgoingPluginChannel(getPlaceholderAPI(), CHANNEL);
            Bukkit.getMessenger().registerIncomingPluginChannel(getPlaceholderAPI(), CHANNEL, this);
        }
    }

    @Override
    public String onRequest(final OfflinePlayer player, String identifier) {
        String[] args = identifier.split("_");
        if (args.length < 3) {
            return "";
        }
        if (placeholdersCache.containsKey(identifier)) {
            return placeholdersCache.get(identifier);
        }
        if (args[1].equals("int")){
            placeholdersCache.put(identifier, String.valueOf(0));
            return String.valueOf(0);
        }
        placeholdersCache.put(identifier, "");
        return "";
    }

    @Override
    public void stop() {
        final BukkitTask prev = cached.getAndSet(null);
        if (prev == null) {
            return;
        }

        prev.cancel();
        placeholdersCache.clear();

        Bukkit.getMessenger().unregisterOutgoingPluginChannel(getPlaceholderAPI(), CHANNEL);
        Bukkit.getMessenger().unregisterIncomingPluginChannel(getPlaceholderAPI(), CHANNEL, this);
    }

    @Override
    public void onPluginMessageReceived(@NotNull String channel, @NotNull Player player, @NotNull byte[] bytes) {
        if (!CHANNEL.equals(channel)) {
            return;
        }
        PluginMessageData pluginMessageData = new Gson().fromJson(new String(bytes), PluginMessageData.class);
        if (pluginMessageData.getType().equals("getPlaceholder")) {
            placeholdersCache.put(pluginMessageData.getSendData(), pluginMessageData.getResponseData());
        }
    }
}
