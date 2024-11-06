# MultiVelocityPapiIntegration

Get the PAPI integration from the release page and put it into the "expansions" folder of your PlaceholdersAPI plugin.

## Usage

Every placeholder is made of 4 + 1 parts:
`velocitylink_<SCOPE>_<TYPE>_<PLACEHOLDER>_<OPTIONALS:DATA>`

Es:
`velocitylink_server_int_players_lobby`

- `SCOPE`: The type of the placeholder, can be `server` or `player`. Server placeholders are global, player placeholders
  are specific to a player.
- `TYPE`: The type of the placeholder, can be `int`, `string`. It's the type of the value that the placeholder will
  return.
- `PLACEHOLDER`: The name of the placeholder. It's the value that will be used to get the value from the placeholder.
- `OPTIONALS:DATA`: The data that the placeholder needs to work. It can be empty or contain some data.

## Placeholders

| Placeholder                                           | Description                                      | Example              |
|-------------------------------------------------------|--------------------------------------------------|----------------------|
| `velocitylink_server_int_players_lobby`               | Get the number of players on specific backend    | `0`                  |
| `velocitylink_server_int_playerstotal`                | Get the number of players on the network         | `0`                  |
| `velocitylink_server_string_status_status_lobby`      | Get the status of a specific backend             | `&2&l✔ Online`       |
| `velocitylink_server_string_int_players_lobby`        | Get the ping given players of a specific backend | `0`                  |
| `velocitylink_server_string_int_maxplayers_lobby`     | Get the max players of a specific backend        | `0`                  |
| `velocitylink_server_string_status_motd_lobby`        | Get the motd of a specific backend               | `A minecraft server` |
| `velocitylink_server_string_status_version_lobby`     | Get the version of a specific backend            | `1.16.5`             |
| `velocitylink_server_string_int_ping_lobby`           | Get the ping of a specific backend (in ms)       | `10`                 |
| `velocitylink_server_string_status_minversion_lobby`  | Get the min version of a specific backend        | `1.16.5`             |
| `velocitylink_server_string_status_maxversion_lobby`  | Get the max version of a specific backend        | `1.16.5`             |
| `velocitylink_server_string_status_online_lobby`      | Get the online status of a specific backend      | `true`               |
| `velocitylink_server_string_status_maintenance_lobby` | Get the maintenance status of a specific backend | `false`              |
| `velocitylink_server_string_status_description_lobby` | Get the description of a specific backend        | `My description`     |
| `velocitylink_server_string_status_name_lobby`        | Get the name of a specific backend               | `Lobby`              |
| `velocitylink_player_string_scan_staffer`             | Staffer that started user scan                   | `Console`            |
| `velocitylink_player_string_scan_pin`                 | Pin of the scan                                  | `ejs72js`            |
| `velocitylink_player_string_scan_time`                | Lasting time of the scan                         | `0h 2m 56s`          |

... more placeholders will be added during development.

## Changelogs

### 1.0

- Initial release
