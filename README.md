<a id="readme-top"></a>
<div align="center">
  <h1 align="center">Scripts In Java</h1>

  <p align="center">
    Ένα repository που περιέχει διάφορα scripts που ανέπτυξα με σκοπό την εξοικείωσή μου με Java, μετά την ολοκλήρωση του W3Schools tutorial!
    Τα scripts τρέχουν σε terminal, χρησιμοποιούν αμυντικό προγραμματισμό για τις εισαγωγές του χρήστη και χειρίζονται ακραίες περιπτώσεις.
    </p>
</div>

## Περιεχόμενα
- [String to array converter](#string-to-array-converter)
- [Palindrome Checker](#palindrome-checker)
- [Guess The Number Game](#guess-the-number-game)
- [Simple Two-Part Calculator](#simple-two-part-calculator)
- [Οδηγίες Εγκατάστασης](#οδηγίες-εγκατάστασης)
- [Μελλοντικές Προσθήκες](#μελλοντικές-προσθήκες)
- [Επικοινωνία](#επικοινωνία)
- [License](#license)


## String to array converter

Ένα απλό script που δέχεται ένα string και το μετατρέπει σε array, το οποίο και τυπώνει. 
Ο χρήστης μπορεί να εισάγει 0 για να τερματίσει το πρόγραμμα, κάτι που υπενθυμίζει το
prompt εισαγωγής σε κάθε επανάληψη.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Palindrome Checker

Το script ζητάει από το χρήστη να εισάγει μία λέξη ή φράση για να ελεγθεί. Εάν ο χρήστης εισάγει
λέξη μικρότερο των 2 χαρακτήρων, το πρόγραμμα δίνει prompt για σωστή εισαγωγή.
Έπειτα, υλοποιείται η μέθοδος reverse() που αντιστρέφει το string με ένα απλό for-each, και το
αποτέλεσμα συγκρίνεται με την αρχική είσοδο. Το πρόγραμμα αγνοεί πεζά-κεφαλαία και δουλεύει και για
ακολουθίες που περιέχουν αριθμούς.
Ο χρήστης μπορεί να εισάγει 0 για έξοδο.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Guess The Number Game

Το script ζητάει το άνω όριο του εύρους για την επιλογή τυχαίου αριθμού με τη μέθοδο get_range(), 
επιλέγει τυχαίο αριθμό και ζητάει από τον χρήστη να εισάγει τη "μαντεψιά" του με τη μέθοδο get_guess().
Έπειτα, το πρόγραμμα δίνει ένδειξη αν ο χρήστης πρέπει να κινηθεί προς υψηλότερη ή χαμηλότερη τιμή, ή, φυσικά,
αν το βρήκε! 

Το πρόγραμμα διατηρεί αριθμό προσπαθειών, λίστα με τους αριθμούς που δοκίμασε ήδη ο χρήστης και 
τον ειδοποιεί αν ξαναδοκιμάσει τον ίδιο αριθμό χωρίς να αυξήσει τον αριθμό προσπαθειών αλλά δίνοντας του πάλι
το hint υψηλότερης ή χαμηλότερης τιμής! Όταν ο χρήστης βρει τον αριθμό, το πρόγραμμα τον ενημερώνει με πόσες 
προσπάθειες το βρήκε, ενώ αν το βρει με την πρώτη τον ειδοποιεί με ιδιαίτερο μήνυμα που τονίζει την πιθανότητα
να συμβεί αυτό! (Εάν μάλιστα η πιθανότητα είναι μικρότερη του 5%, τυπώνει ένα έξτρα μήνυμα)

Υπάρχει αμυντικός προγραμματισμός για τη λήψη μη αριθμητικής τιμής, τιμής εκτός του εύρους, έυρους
μικρότερου του 5 (για να είναι ενδιαφέρον το παιχνίδι) και ο χρήστης μπορεί να τερματίσει το πρόγραμμα σε
οποιαδήποτε φάση πληκτρολογώντας -1.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Simple Two-Part Calculator

Το πρόγραμμα ζητάει μια αριθμητική παράσταση δύο μέρων για να υπολογίσει. Δέχεται ακέραιους και δεκαδικούς 
αριθμούς (είτε με , είτε με . ), πρόσθεση, αφαίρεση, πολλαπλασιασμό, διαίρεση και ύψωση σε δύναμη.
Χρησιμοποιείται RegularExpressions (RegEx) για εντοπισμό μη αποδεκτών χαρακτήρων και, σε περίπτωση εύρεσής
τους, ειδοποιείται ο χρήστης με το κατάλληλο μήνυμα καθώς και υπόδειξη σωστής χρήσης.

Το πρόγραμμα έπειτα ελέγχει αν η παράσταση είναι όντως 2 μερών και όχι παραπάνω, ειδοποιώντας το χρήστη
με το ανάλογο μήνυμα σε περίπτωση προβλήματος. Στη συνέχεια, "μεταφράζει" τους αριθμούς που εισήχθησαν από
string σε int/float, εντοπίζει την επιθυμητή πράξη, την εκτελεί και επιστρέφει το αποτέλεσμα.

Ο χρήστης μπορεί να εξέλθει εισάγοντας exit, χωρίς διάκριση πεζών-κεφαλαίων.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Οδηγίες Εγκατάστασης

1. Clone του repo
   ```sh
   git clone https://github.com/BlackBaron94/Scripts-In-Java.git
   ```

Για να τρέξουν τα αρχεία .java χρειάζονται εγκατεστημένη έκδοση Java "1.8.0_441"

2. Έλεγχος εγκατεστημένης έκδοσης Java
   ```sh
   java -version
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Μελλοντικές Προσθήκες

- [X] String to array converter.
- [X] Palindrome Checker.
- [X] Guess The Number Game.
- [X] Two-Part Calculator.
- [ ] Διαχείριση περιπτώσεων που μία παράσταση λαμβάνεται ως 2 στο Two-Part Calculator (πχ -31 + 5 = 5-31)
- [ ] To-do list (CRUD functions).
- [ ] File I/O (read data, search words/give stats, write stats on different file).
- [ ] Simple Tic Tac Toe.
- [ ] Multi-Part Calculator.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Επικοινωνία

Γιώργος Τσολακίδης - [Linked In: Giorgos Tsolakidis](https://www.linkedin.com/in/black-baron/) - black_baron94@hotmail.com 

Project Link: [Scripts In Java](https://github.com/BlackBaron94/Scripts-In-Java/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## License


This project is licensed under the MIT License – see the [LICENSE](./LICENSE) file for details.

<p align="right">(<a href="#readme-top">back to top</a>)</p>
