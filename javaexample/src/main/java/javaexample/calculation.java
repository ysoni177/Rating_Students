package javaexample;

public class calculation {
	static int test_score(int testp[],int testn)
	{
		int tot_test=testn;
		int avg_test=0;
		while(tot_test>0)
		{
		 avg_test+=((40/tot_test)*testp[testn])/100;
		 tot_test--;
		}
		
		return avg_test;
	}
	static int lab_score(int labp[],int labn)
	{
		int tot_lab=labn;
		int avg_lab=0;
		while(tot_lab>0)
		{
		 avg_lab+=((10/tot_lab)*labp[labn])/100;
		 tot_lab--;
		}
		return avg_lab;
	}
	static int quiz_score(int quizp[],int quizn)
	{
		int tot_quiz=quizn;
		int avg_quiz=0;
		while(tot_quiz>0)
		{
		 avg_quiz+=((20/tot_quiz)*quizp[quizn])/100;
		 tot_quiz--;
		}
		return avg_quiz;
	}
	static int project_score(int projectp[],int projectn)
	{
		int tot_project=projectn;
		int avg_project=0;
		while(tot_project>0)
		{
		 avg_project+=((30/tot_project)*projectp[projectn])/100;
		 tot_project--;
		}
		return avg_project;
	}
	static int overall_score(int t,int p,int l,int q)
	{
		int avg_sum=t+p+l+q;
		return avg_sum;
	}
}
