# Polybius Cypher

A Java implementation of the Polybius Cipher (or "Polybius Square") used by the
ancient Greeks to encrypt and decrypt text.

## About

Polybius Cypher encrypts or decrypts text input depending on the option selected
by the user from the menu (These options are discussed below.). Input can be in
the form of text manually entered into the console, or in the form of a file on
the system. In the case of text entered manually, the resultant encrypted or
decrypted text is printed to the console. In the case of a file, the resultant
encrypted or decrypted text is placed in a file and saved to the user's system
at the path provided by the user. A message is printed to the console to confirm
that the process is complete, and states the name of the newly created file and
its location.

Encryption and decryption are carried out using the Polybius Square found in the
Cypher class and a keyword provided by the user. The keyword and text provided
by the user can be of any length, and no data other than newlines is lost during
the encryption / decryption process. A very short keyword can result in an
encrypted text that contains a large number of whitespace characters, but
encryption and decryption still work. Both the keyword and the text provided
(either manually or in the form of a file) has each of its characters
capitalised. This is to make each step in encryption and decryption easier to
perform but results in all output being capitalised. Output is also always a
single line of characters with no newline characters or newline character
sequences included.

As the Polybius Square only contains letters and integers, these are the only
characters allowed in the keyword provided by the user. The text provided to the
program to be encrypted or decrypted can contain any characters. Characters that
don't exist in the Polybius Square are simply added to the output without being
altered.

The program is designed to be used with manually input text or .txt files
exclusively.

### Compatibility

The program was written working with Java 8. (1.8.0_212). It has not been
tested in any other environment.

## Usage

When the program starts, a list of options is printed to the console. These can
be selected by typing the integer which corresponds with the desired option into
the console and pressing Enter. The options are:

### 1. Set New Keyword:

- Prompts user to input keyword as text in the console.
- Confirms new key has been set and prints new keyword to console.
- Alternatively, prints message explaining key is invalid and key has not been
set.

### 2. Encrypt Text (Manual Entry):

- If no keyword has been set, prints message explaining a key must be set to
continue.
- Prompts user to input text into console to be encrypted.
- Prints message confirming encryption is complete and prints encrypted text to
the console.
- A message including the duration of the encryption process in milliseconds is
printed to the console.

### 3. Decrypt Text (Manual Entry):

- If no keyword has been set, prints message explaining a key must be set to
continue.
- Prompts user to input text into console to be decrypted.
- Prints message confirming decryption is complete and prints decrypted text to
the console.
- A message including the duration of the decryption process in milliseconds is
printed to the console.
- Alternatively, a message is printed to the console explaining that decryption
has failed and why it has failed.

### 4. Encrypt Text File:

- If no keyword has been set, prints message explaining a key must be set to
continue.
- Prompts user to input the name of a file to be encrypted, including its full
path on the system. If an invalid path or filename is input, an error explaining
this is printed to the console.
- Prompts user to input the name of a new file to be created which will contain
the encrypted text, including its full path on the system. If the file already
exists, it is simply overwritten.
- A message including the duration of the encryption process in milliseconds is
printed to the console.
- Alternatively, a message is printed to the console explaining that encryption
has failed and why it has failed.

### 5. Decrypt Text File:

- If no keyword has been set, prints message explaining a key must be set to
continue.
- Prompts user to input the name of a file to be decrypted, including its full
path on the system. If an invalid path or filename is input, an error explaining
this is printed to the console.
- Prompts user to input the name of a new file to be created which will contain
the encrypted text, including its full path on the system. If the file already
exists, it is simply overwritten.
- A message including the duration of the decryption process in milliseconds is
printed to the console.
- Alternatively, a message is printed to the console explaining that encryption
has failed and why it has failed.

### 6. Quit:

- A brief goodbye message is printed to the console and the program stops
running.

## Contact

### Barry Sheehan

* Home page: [BarrySheehan.com](http://www.barrysheehan.com)
* Twitter: [@barrymsheehan](https://twitter.com/barrymsheehan)

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE.md](LICENSE.md) file for details.