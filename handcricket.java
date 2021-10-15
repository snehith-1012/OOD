/* package codechef; // don't place package name! */
import java.util.*;
import java.lang.*;
import java.io.*;


class game
{
    round[] r=new round[3];
    game(int[][] player1,int[][] player2)
    {
        for(int i=0;i<player1.length;i+=2)
        {
            r[i/2]=new round(i%2,player1[i],player1[i+1],player2[i],player2[i+1]);
        }
    }
}

class round
{
    innings[] s=new innings[2];
    round(int innings_number,int[] sr11,int[] sr12,int[] sr21,int[] sr22)
    {
        s[innings_number]=new innings(sr11,sr12);
        s[innings_number+1]=new innings(sr21,sr22);
    }
}

class innings
{
    player_a playera;
    player_b playerb;
    innings(int[] one,int[] two) 
    {
        playera=new player_a(one,one.length);
        playerb=new player_b(two,two.length);
    }
}
class player 
{
    int no_of_turns;
    int []arr=new int[15];
    int playerscore()
    {
        int sum=0;
       for(int i=0;i<no_of_turns-1;i++)
       {
           if(arr[i+1]>=1 && arr[i+1]<=6)
            sum=sum+arr[i]; 
       }
       return sum;
    }
}
class player_a extends player
{
    
    player_a(int []one,int size)
    {
        no_of_turns=size;
        arr=one;
    }
}

class player_b extends player
{
    player_b(int []two,int size)
    {
        no_of_turns=size;
        arr=two;
    }
}

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc=new Scanner(System.in);
		char toss_win;
		String tmp;
		tmp=sc.next();
		toss_win=tmp.charAt(0);
		game g;
		int player1[][]=new int[6][15];
		int player2[][]=new int[6][15];
		for(int i=0;i<6;i++)
		{
		    int t=15;
		    while(t>0)
		     {
		       int x,y;
		       x=sc.nextInt();
		       y=sc.nextInt();
		       player1[i][15-t]=x;
		       player2[i][15-t]=y;
		       if(x==y)
		       break;
		       t=t-1;
		     }
		}
		g=new game(player1,player2);
	    int a_win=0,b_win=0;
	    
	    for(int i=0;i<3;i++)
	    {
	        int x=0,y=0;
	        if(i%2==0 && toss_win=='A')
	        {
	            x=g.r[i].s[0].playera.playerscore();
	            y=g.r[i].s[1].playerb.playerscore();
	        }
	        else if(i%2!=0 && toss_win=='A')
	        {
	            x=g.r[i].s[1].playerb.playerscore();
	            y=g.r[i].s[0].playera.playerscore();
	        }
	        else if(i%2==0 && toss_win=='B')
	        {
	            x=g.r[i].s[0].playerb.playerscore();
	            y=g.r[i].s[1].playera.playerscore();
	        }
	        else if(i%2!=0 && toss_win=='B')
	        {
	            x=g.r[i].s[0].playera.playerscore();
	            y=g.r[i].s[1].playerb.playerscore();
	        }
	        if(x>y)
	            a_win++;
	        else if(x<y)
	            b_win++;
	        if(x>y)
	        {
	         System.out.print(i);
	         System.out.println("th round");
	         System.out.print("points=");
	         System.out.print(x);
	         System.out.println();
	         System.out.println("a won");
	        }
	        else
	        {
	            System.out.print(i);
	            System.out.println("th round");
	            System.out.print("points=");
	            System.out.print(y);
	            System.out.println();
	            System.out.println("b won");
	        }
	    }
	    System.out.println("finally");
	    if(a_win>b_win)
	    System.out.println("a wins");
	    else if(a_win<b_win)
	    System.out.println("b wins");
	}
}
