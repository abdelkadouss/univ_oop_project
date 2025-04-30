
alias l := list
alias c := clean
alias r := run
alias b := build

default:
  @just --list

run: build
  @java -cp . maktaba.App

build:
  @javac -d . src/main/java/maktaba/*.java

clean:
  @rm -rf *.class

list:
  @just --list
