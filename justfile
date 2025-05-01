alias l := list
alias c := clean
alias r := run
alias b := build
alias w := watch

default:
  @just --list

run *args: build
  @java -cp target App {{args}}

build:
  @rm -rf ./target
  @javac -d ./target $(find src/main/java -name "*.java")

clean:
  @rm -rf *.class

list:
  @just --list

watch *args:
  @watchexec -w src just run {{args}}
