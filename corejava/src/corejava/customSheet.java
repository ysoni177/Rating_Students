package corejava;

public class customSheet {
	public double scoreTest, scoreQuiz, scoreLab, scoreProject;
	public int numTest, numQuiz, numLab, numProject;
	customSheet(){
		numTest = 0;
		numQuiz = 0;
		numLab = 0;
		numProject = 0;
		scoreTest = 0;
		scoreLab = 0;
		scoreProject = 0;
		scoreQuiz = 0;
	}
	void addData(String assCA, int point) {
		String ass = assCA.split("_")[0];
		System.out.println(assCA + ":::" + point + ":::" + ass);
		if(ass.equals("test")) {
			numTest++;
			scoreTest += point;
		}
		else if(ass.equals("quiz"))
		{
			numQuiz++;
			scoreQuiz+=point;
		}
		else if(ass.equals("lab"))
		{
			numLab++;
			scoreLab+=point;
		}
		else if(ass.equals("project"))
		{
			numProject++;
			scoreProject+=point;
		}
	}
	void printData(){
		if(numTest == 0) {
			System.out.print("NA    ");
		} else {
			double finalScore = (scoreTest * 0.4f) / numTest;
			System.out.print(finalScore + "    ");
		}
		
		if(numLab == 0) {
			System.out.print("NA    ");
		} else {
			double finalScore = (scoreLab * 0.1f) / numLab;
			System.out.print(finalScore + "    ");
		}
		if(numQuiz == 0) {
			System.out.print("NA    ");
		} else {
			double finalScore = (scoreQuiz * 0.2f) / numQuiz;
			System.out.print(finalScore + "    ");
		}
		if(numProject == 0) {
			System.out.print("NA    ");
		} else {
			double finalScore = (scoreProject * 0.3f) / numProject;
			System.out.print(finalScore + "    ");
		}
		
		
	}

}
