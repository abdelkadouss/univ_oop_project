<div align="center"> بسم الله الرحمن الرحيم </div>


# Pre requisites

- Jdk 23
- any Unix-like OS (recommended for easly following the instructions incha'Allah) (for windows users it's recommended to use WSL)

# Installation and Usage
1. Clone the repository
2. Open the terminal and navigate to the project directory
3. compile the source using javac
4. run the program using java

```bash
git clone https://github.com/abdelkadouss/maktaba.git
cd maktaba
# compile the source
javac -d ./target $(find src/main/java -name "*.java")
# run the program
java -cp target App # now you can pass the arguments here
# for help run
java -cp target App help
```

to make it easier to use you can make alias (optional)

```bash
alias maktaba="java -cp target App"
```

# Usage Examples

```bash
# we here using the alias for easy use
maktaba help
# list all the books
maktaba -b list # -b for book and -r for borrowers
maktaba -r list
# add a book
maktaba -b add book_name PAPER writer true # true for available
# type can be PAPER or ELECTRONIC
# now let's see the books incha'Allah
maktaba -b list
# add a borrower
maktaba -r add borrower_name 1,3,5 # 1,3,5 are the book ids (NOTE: don't use spaces between the ids just a cama ",")
maktaba -r list
# let's borrow a book
maktaba -r borrow 1 1 # the first argument is the book id and the second is the borrower id
maktaba -r list # look at the borrower 1 books
maktaba -b list # look at the book 1 status
# now let's return the book
maktaba -r return 1 1
maktaba -r list # look at the borrower 1 books
maktaba -b list # look at the book 1 status
# ok now let's view a book
maktaba -b get 1 # the book id
# now let's view a borrower
maktaba -r get 1 # the borrower id
```

> NOTE: the app stores the data in a file called books.txt and borrowers.txt
> you can display it using the command `cat books.txt` and `cat borrowers.txt`

# License
no of use is permitted except reviweing it by the teacher of the app developer (for now)
