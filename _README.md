# How to run

* adjust parameters in main_run.ps
* `gswin64c.exe .\programs\pow.ps .\runtime.ps .\compiler.ps .\main_run.ps`

# How to compile

* `gswin64c.exe .\programs\pow.ps .\compiler.ps .\main_compile.ps`
* Copy compiled code (except first '[' and last ']')
* `gswin64c.exe .\runtime.ps output.ps`


# Bytecode instructions

There is a list of JVM bytecode instructions on [Wikipedia](https://en.wikipedia.org/wiki/Java_bytecode_instruction_listings).