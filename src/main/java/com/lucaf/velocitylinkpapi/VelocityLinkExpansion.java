package com.lucaf.velocitylinkpapi;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.clip.placeholderapi.expansion.Taskable;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;

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

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void onPluginMessageReceived(@NotNull String s, @NotNull Player player, @NotNull byte[] bytes) {

    }
}
