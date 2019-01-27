package me.ressources.mode.wordgestion.gamemode;

public class Error
{

	private String question;
	private String answerOnUser;
	private String trueAnswer;
	
	public Error(String question, String answerOnUser, String trueAnswer)
	{
		this.question = question;
		this.answerOnUser = answerOnUser;
		this.trueAnswer = trueAnswer;
	}

	public String getQuestion()
	{
		return question;
	}

	public String getAnswerOnUser()
	{
		return answerOnUser;
	}

	public String getTrueAnswer()
	{
		return trueAnswer;
	}

	public void setTrueAnswer(String trueAnswer)
	{
		this.trueAnswer = trueAnswer;
	}

	public void setQuestion(String question)
	{
		this.question = question;
	}

	public void setAnswerOnUser(String answerOnUser)
	{
		this.answerOnUser = answerOnUser;
	}
}
