## NLP Programming Exercise

**Instructions**:<br />
Create a command-line Java application that given a path to a text file it will report the total count of:
* Words
* Sentences
* Paragraphs
---
**How to use:**
1. Clone repository  `git clone https://github.com/nperry0/NLPExercise.git`
2. Change directory `cd NLPExercise/NLPExercise/src/`
3. Compile java program `javac TextCounter.java`
4. Run java program:<br />
&nbsp;&nbsp;&nbsp;&nbsp; to run the included sample text -> `java TextCounter sampletext.txt`<br />
&nbsp;&nbsp;&nbsp;&nbsp; to run a different text file -> `java TextCounter <text-path>`
---
**Questions**:
1. What does your application consider a word?<br />
  A word is a string of one or more alphabetical characters. The word can contain an apostrophe (') or a hyphen (-). A word can also be an acronym consisting of at least two consecutive pairs of a capital letter (A-Z) and a period (.).<br />
  *Regex pattern to match*: `(([A-Z]{1}\.{1}){2,})|([a-zA-Z]+[-']?[a-zA-Z]+|[Ia])`
  
2. What does your application consider a sentence?<br />
  A sentence is a collection of words that ends in a sentence break. A sentence break consists of a punctuation marker (. - ! ?), followed by an optional quotation mark ("), and whitespace (/s) before the next sentence.<br />
  *Regex pattern to match*: `\w*[\.\-!\?]+"?\s`
  
3. What does your application consider a paragraph?<br />
  A paragraph is a collection of one or more sentences that ends in a newline control character (\n).<br />
  *Regex pattern to match*: `\n`
---
**Additional Notes:**<br />

- The original approach was to break down the text sequentially into paragraphs, then sentences, and finally into words. Each step would create a list of strings for that goal, and then return the length of the list. This ended up being really unnecessary unless we were trying to do something with the lists afterwards, so I changed tactics.
- The counting of paragraphs could take place while converting the file to string, but ultimately I wanted the three counting functions to take the same input.
- Room for improvement in word-counting algorithm: <br />
&nbsp;&nbsp;&nbsp;&nbsp; - Absorb the 'or I or a' into the rest of the regex <br />
&nbsp;&nbsp;&nbsp;&nbsp; - Until then, add capital 'A' to 'or I or a' <br />
&nbsp;&nbsp;&nbsp;&nbsp; - Include numerical characters  <br />
- Room for improvement in sentence-counting algorithm: <br />
&nbsp;&nbsp;&nbsp;&nbsp; - Consider situations where acronyms happen at the middle or end of a sentence  <br />
&nbsp;&nbsp;&nbsp;&nbsp; - Explore other potential punctuation situations  <br />
- Room for improvement in paragraph-counting algorithm: <br />
&nbsp;&nbsp;&nbsp;&nbsp; - Determine any situations where current algorithm could fail  <br />
