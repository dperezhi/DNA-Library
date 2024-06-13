## My Project: DNA Sequence Editor

**What will the application do & why is it of interest to me?**
This software will allow the user to add a DNA sequence to a Sequence collection. The name, author, and specific part 
(promoter, CDS, etc) will be able to be denominated by the user. It will allow the user to add MoClo and/or BioBrick 
flanks to the sequence. It will tell the user if the input sequence contains an invalid character i.e. A, G, C, and T. 
Lastly, it will translate the DNA sequence into a protein sequence (polypeptide). 

***Why?*** I am passionate about the intersection of *synthetic biology* and *programming* and I believe that 
computation will allow future researchers to tap into and ethically modify *the code of life*.

**Who will use it?**
- Researchers: Synthetic Biologists, Geneticists, etc 
- Students and undergraduate biology/chemistry clubs
- Synthetic Biology enthusiasts and hobbyists

### User Stories
#### Phase 1
- As a user, I want to be able to add a DNA sequence to a DNA list. I want to be able to specify
the name, the nucleotide sequence, and the organism of origin.
- As a user, I want to be able to see my list and choose a DNA sequence to modify.
- As a user, I want to be able to add MoClo flanks to my DNA sequences.
- As a user, I want to be able to see DNA sequences translated into a protein sequence.
#### Phase 2
- As a user, when I select the quit option from the application menu, I want to be reminded to save my Dna Sequence list 
to a file and have the option to do so or not. 
- As a user, when I start the application, I want to be given the option to load my DNA sequence list from file.
#### Phase 3
- As a user, I want the software to check that all the characters in my DNA sequence are valid

##### Instructions for the user
a list of step-by-step instructions for interacting with your GUI that describes:
- You can generate the first required action related to the user story "adding multiple Xs to a Y" by clicking the + 
sign button on the top right of the left side panel to add DNAs to your library.
- You can generate the second required action related to the user story "adding multiple Xs to a Y" by clicking the DNA
you will be able to see the specific details of that DNA on the workspace on the right side panel.
- You can locate my visual component when you click the save button you will see a cheetah picture. Moreover, the DNA 
buttons have a DNA image on the left. 
- You can save the state of my application by clicking the save icon.
- You can reload the state of my application by clicking the load icon with the "correct" file name.


#### Phase 4: Task 2
Thu Nov 30 17:23:56 PST 2023
Created new DNA folder: Default

Thu Nov 30 17:23:56 PST 2023
Created New DNA:  test1

Thu Nov 30 17:23:56 PST 2023
Added DNA: test1 to folder

Thu Nov 30 17:23:56 PST 2023
Created New DNA:  test2

Thu Nov 30 17:23:56 PST 2023
Added DNA: test2 to folder

Thu Nov 30 17:23:56 PST 2023
Created New DNA:  test3

Thu Nov 30 17:23:56 PST 2023
Added DNA: test3 to folder

Thu Nov 30 17:23:56 PST 2023
Created New DNA:  test4

Thu Nov 30 17:23:56 PST 2023
Added DNA: test4 to folder

Thu Nov 30 17:24:04 PST 2023
Created New DNA:  Diego

Thu Nov 30 17:24:04 PST 2023
Added DNA: Diego to folder

Thu Nov 30 17:24:04 PST 2023
Loaded DNA folder: default from ./data/dnaLibrary.json

#### Phase 4: Task 3
With more time I would reduce the amount of classes while also reducing redundant code in my program. Moreover, I would 
add helping classes (refactoring) to improve the readability of the program as well as the structure. I also want to add
other functions to the program and as such I need to refactor to make adding those easier. The main refactoring change I
would do is the implementation of classes set up just from the JFrame and JPanel setup, as well as removing redundant code 
currently found in all classes that do the same thing.
