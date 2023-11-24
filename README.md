# ClassicSaveFixer
A NilLoader mod that fixes Classic Minecraft's Load/Save dialogs, allowing the game to actually save files locally.

## Building
The current version of NilGradle gets confused by classic mappings causing the mod to need to be built in 3 stages. These can be run via a bash command:
```bash
./gradlew clean && ./gradlew check && ./gradlew build
```

## Decompiling
Decompiling is broken on classic versions. Something about the class files just break VineFlower.
