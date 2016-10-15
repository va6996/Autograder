# Autograder

Autograder is the offline version of online code judges like SPOJ, Topcoder, Hackerearth, etc bosed on Java Swings. User selects a question, chooses their preferred language and submits the code. The grader compiles and tests the code for correctness. If there is a compilation error or execution error or TLE, it is shown to the user in the results page.

##Screenshots
![](https://s11.postimg.org/8mqop8len/code.png)
![](https://s11.postimg.org/8o0minn8f/question.png)
![](https://s11.postimg.org/sjwly749r/results.png)

##Idea
The idea is that we have HTML files for all the questions. We also have all the test cases and final outputs stored in a file. The user submits their solution and the code is compiled using required commands. The compiler gives no output if there is no error, else compilation error is shown. Then the program is exectuted using the test cases provided. All the results are matched with the corresponding solution file. If there is no error, success is indicated to the user. All stdio in the code is piped to file I/O.
