package com.example.millionairequiz;

public class QuestionAnswerList {

    //List of questions
    public static String[] questions ={
            "In Ancient Egyptian Mythology, Who Was The God Of The Sun?",
            "The Ancient Incan Ruins Of Machu Picchu Are In Which Country?",
            "At Which London Landmark Was Anne Boleyn Executed?",
            "Which Of These Is A Book Of The Bible?",
            "A Fire Hydrant In What City Gets A Fresh Coat Of Gold Paint Each Year In Thanks For Its Service In 1906?",
            "Pol Pot Was A Leader Of Which Country In The 1970s?",
            "Who Is The Only Best Actress Oscar Winner To Also Win An Oscar For Best Original Song?",
            "Who Was The US President At The Outbreak Of World War One?",
            "By What Name Was The City Of St. Petersburg Known Between 1924-1991?",
            "What Was The Surname Of Lucrezia, The Daughter Of Pope Alexander VI?",
            "Desdemona Is The Wife Of Which Shakespearean Title Character?",
            "Introduced In 1914 And Still In Use, Whose Ad Slogan Was Designed To Emphasize Its Ability To Flow In Bad Weather?",
            "Umberto II Was The Last King Of Which European Country?",
            "Edward Jenner Discovered The Vaccination For Smallpox By Infecting A Boy With What Disease?"
    };
    //list of answers to choice from
    public static String[][] choices = {
            {"Ra","Horus","Osiris","Geb"},
            {"Peru","Chile","Argentina","Mexico"},
            {"Charing Cross","Westmister Abbey","Tower of London","Luggate Hill"},
            {"Song of Samuel","Song of Saul","Song of Solomon","Song of Samson"},
            {"Miami","Boston","Denver","San Francisco"},
            {"Laos","Thailand","Cambodia","Burma"},
            {"Julie Andrews","Barbra Streisand","Liza Minnelli","Cher"},
            {"Calvin Coolidge","Herbert Hoover","William Taft","Woodrow Wilson"},
            {"Stalingrad","Petrograd","Nizhniy Novogorod","Leningrad"},
            {"Borgia","Giorgioni","Medici","Ponti"},
            {"Mecbeth","King Lear","Othello","Hamlet"},
            {"Heinz Ketchup","Morton Salt","Mrs. Butterworth's syrup","Folgers Coffee"},
            {"Italy","France","Spain","Germany"},
            {"Horsepox","Cowpox","Goatpox","Chicken pox"}
    };
    //Correct answer for each question
    public static String[] correctAnswers = {
            "Ra", "Peru", "Tower of London", "Song of Solomon", "San Francisco", "Cambodia","Barbra Streisand",
            "Woodrow Wilson", "Leningrad", "Borgia", "Othello", "Morton Salt",  "Italy", "Cowpox"
    };
    // prize money for each question
    public static Integer[] EarningList = {
            500, 1000, 2000, 3000, 5000, 7000, 10000, 20000, 30000, 50000, 100000, 250000, 500000, 1000000
    };
}
