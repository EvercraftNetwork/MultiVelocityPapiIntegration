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

| Placeholder                             | Description                                    | Example |
|-----------------------------------------|------------------------------------------------|---------|
| `velocitylink_server_int_players_lobby` | Get the number of players on the lobby backend | `0`     |
| `velocitylink_server_int_playerstotal`  | Get the number of players on the network       | `0`     |

... more placeholders will be added during development.

## Changelogs
### 1.0
- Initial release
