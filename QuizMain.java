
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;


/**
 * 
 * This is a simple quiz game! The player is asked five questions and given four possible answers (1 correct, 3 false).
 * The player chooses A, B, C, or D. The game ends when all five questions are answered. When the game ends, the player
 * is given a score and some feedback.
 * 
 * @author Roosa
 *
 */


public class QuizMain {
	
	public static void main(String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random randomGen = new Random();
		
		//Initialize a list of questions
		ArrayList<Question> questions = init();
		
		/*
		 * Initializing variables for Question object, an Integer for keeping the player's score,
		 * a random variable for generating random index numbers, and a String name for the player's name.
		 */
		Question currentQuestion;
		int score = 0;
		int random;
		String name;
		
		//a chart for displaying the different answer options. There are four keys (A, B, C, and D), and the
		//values are the answer options of a Question object.
		Map<String, String> questionChart = new HashMap<String, String>();
		
		System.out.println("Welcome to play a small quiz! What's your name?");
		name = scanner.nextLine();
		System.out.println("Hello, " + name + "! You will be asked five different questions, and you are given four different options: A, B, C, and D.");
		System.out.println("Type the letter you think is the correct answer.");
		System.out.println("Good luck, " + name + "! To start the game, press enter.");
		scanner.nextLine();
		
		//A for-loop for keeping the game running for 5 different questions
		for (int i = 0; i < 5; i++) {

			//get a new current question that the player answers. The chosen question is deleted from the
			//list so that it won't be asked two times.
			random = randomGen.nextInt(questions.size());
			currentQuestion = questions.get(random);
			questions.remove(random);

			//the questions are set to the question chart
			questionChart = assignQuestionsToMap(currentQuestion, questionChart);

			System.out.println(currentQuestion);

			System.out.print("A. " + questionChart.get("A") + " ");
			System.out.print("B. " + questionChart.get("B") + " ");
			System.out.print("C. " + questionChart.get("C") + " ");
			System.out.println("D. " + questionChart.get("D"));

			System.out.println("What's your answer?");

			String answer = scanner.nextLine();

			answer = answer.toUpperCase();

			//A while loop that runs until the player types A, B, C, or D.
			while (!(answer.equals("A") | answer.equals("B") | answer.equals("C") | answer.equals("D"))) {
				System.out.println("Please, type A, B, C or D.");
				answer = scanner.nextLine();
				answer = answer.toUpperCase();
			}

			//check the currentQuestion's correct answer to see if it matches the
			//player's input. If it's a match, the player gets a point, if not, the game continues.
			if (questionChart.get(answer).equals(currentQuestion.getCorrectAnswer())) {
				System.out.println("That's correct!");
				score++;

			} else {
				System.out.println("That's not quite right...");
			}
		
		}
		
		//Print out the final score for the player and give them some feedback
		System.out.println("Your score is: " + score + "/5");

		switch (score) {
		case 5: System.out.println("Amazing!");
		break;

		case 4: System.out.println("You have definitely read a book or two, " + name + "!");
		break;

		case 3: System.out.println("Well done!");
		break;

		case 2: System.out.println("You're half-way of knowing it all!");
		break;

		case 1: System.out.println("You tried, " + name + ", and therefore no one can criticise you.");
		break;

		case 0: System.out.println("Look at the positive side: there's a lot of room for new information in your head!");
		break;

		default: System.out.println("No score found.");
		break;
		}
		
		//The programme stops running after thanking the player and closing the scanner
		System.out.println("Thank you for playing, " + name + "!");


		scanner.close();
	
		
		
	} //END OF main METHOD
	
	
	/*
	 * 
	 * A method to set the current questions to questionChart.
	 * 
	 * @.pre question != null, map != null
	 * @.post map.size() == 4
	 * 
	 */
	public static Map<String, String> assignQuestionsToMap(Question question, Map<String, String> map) {
		
		//mess up the order of the questions by putting them in an ArrayList and using
		//the Collections' shuffle method
		
		ArrayList<String> questionAnswers = new ArrayList<String>();
		questionAnswers.add(question.getCorrectAnswer());
		questionAnswers.add(question.getWrongAnswer1());
		questionAnswers.add(question.getWrongAnswer2());
		questionAnswers.add(question.getWrongAnswer3());
		
		//Shuffle the order of questions
		Collections.shuffle(questionAnswers);
		
		//Put the questions in the map
		map.put("A", questionAnswers.get(0));
		map.put("B", questionAnswers.get(1));
		map.put("C", questionAnswers.get(2));
		map.put("D", questionAnswers.get(3));
		
		return map;
		
	} //END OF assignQuestionsToMap METHOD

	
	/*
	 * 
	 * A method that creates a list of questions that the game is going to use.
	 * @.post questionList != null && questionList.size > 0
	 * 
	 */
	
	public static ArrayList<Question> init() {
		
		ArrayList<Question> questionList = new ArrayList<Question>();
		
		questionList.add(new Question("What's the capital of Finland?", "Helsinki", "Hilsinki",
				"Halsinki", "Hulsinki"));
		questionList.add(new Question("What does the fox say?", "Nobody really knows", "Woof", "Meow", "Tweet"));
		questionList.add(new Question("Which insect inspired the term 'computer bug'?", "Moth", "Roach", "Wasp", "Fly"));
		questionList.add(new Question("Who's the protagonist of the movie 'Die Hard'?", "John McClane", "Jake Peralta", "Harry Stamper", "Jake MacClane"));
		questionList.add(new Question("Which one of the following is NOT a star in the Big Dipper constellation (Otava)?", "Altair", "Megrez", "Alkaid", "Phecda"));
		questionList.add(new Question("Which one of the following is NOT a dragon on the TV-series 'Game of Thrones'?", "Nymeria", "Drogon", "Viserion", "Rhaegal"));
		questionList.add(new Question("How many James Bond films are there (Spectre being the latest)?", "24", "50", "30", "26"));
		questionList.add(new Question("What breed is Sauli Niinistö and Jenni Haukio's dog Lennu?", "Boston terrier", "French bulldog", "Chihuahua", "Golden retriever"));
		questionList.add(new Question("Who has composed the Finnish national anthem, 'Maamme'?", "Fredrik Pacius", "Jean Sibelius", "Robert Kajanus", "Armas Launis"));
		questionList.add(new Question("What is the largest desert in the world called?", "Sahara", "Kalahari", "Thar", "Sonoran"));
		questionList.add(new Question("What is the name of the horse that is often seen in the streets of Turku?", "Kullannuppu", "Hulmuharja", "Ilon Pilke", "Valo"));
		questionList.add(new Question("How many different known species of shark are there?", "Over 400", "Less than 100", "200", "340"));
		
		
		return questionList;
		
	} //END OF init METHOD

} //END OF QuizMain CLASS
