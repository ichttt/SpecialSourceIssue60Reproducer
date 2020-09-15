# Special Source Issue 60 Reproduces

### Introduction:
Lambda method calls are incorrectly reobfuscated.
As such, I have created a set of test classes to reproduce it on a small, simple set of files.

- The files in the package `specialsource.orig` should represent a deobfuscated and decompiled jar (like minecraft).
- The files in the package `ichttt.testspecialsource` should represent a mod that is developed against the decompiled codebase and needs to be recompiled

For the deobfuscated jar that needs to be reobfuscated by SpecialSource, you can use the `deobf.jar` file in the data dir or build this project and remove the entire `specialsource.orig` package from the jar

To get the same jar as `obf.jar`, you need to run the deobf jar through special source with the following parameters: `--in-jar "data\deobf.jar" --out-jar "data\obf.jar" --srg-in "data\mapping.tsrg" --live`

The mappings file has been hand-crafted by viewing the java bytecode (using bytecodeviewer) of the `specialsource.orig` package and extracting the relevant information

### Where is the issue
If you inspect the reobf jar, the `invokedynamic` calls to `LambdaMetafactory.metafactory` have the lambda methods incorrectly remapped.
Instead of still referencing `lambda$init$1` and `lambda$init$0` from the mod jar, they reference the obfuscated lambda methods of the super class (`func_2` and `func_3`).

This should not happen, the call should not be remapped at all.