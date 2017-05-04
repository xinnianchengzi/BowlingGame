import java.util.Scanner;
public class BowlingGame {

    public static int getBowlingScore(String bowlingCode) {
    	String b;
    	b=bowlingCode;
    	int score=0;
    	String[] bArr=b.split("\\|");
    	for(int i=0;i<9;i++){
    		String temp=bArr[i];
    		int templen=temp.length();
    		if(templen==1){
                String temp1=bArr[i+1];
        		int templen1=temp1.length();
        		char [] temparr1=temp1.toCharArray();
        		if(templen1==1){    //strike
        			if(i==8){
        				i=i+1;   //第9格有特殊情况
        			}
        			String temp2=bArr[i+2];
        			int templen2=temp2.length();
            		char [] temparr2=temp2.toCharArray();
        			if(temparr2[0]=='X'){   //由于第9格的特殊情况，用内容取代长度来判断
        				score+=30;
        			}
        			else if(templen2==2){
        				if(temparr2[0]>='1'&&temparr2[0]<='9'){
        					score+=20+(temparr2[0]-'0');
        				}
        				else{
        					score+=20;
        				}
        			}
        			else{
        				return -1;
        			}
    			}
        		else if(templen1==2){	
        			if(temparr1[1]=='/'){   //sparse
        				score+=20;
        			}
        			else{
        				if(temparr1[0]>='1'&&temparr1[0]<='9'){
        					score+=temparr1[0]-'0';
        				}
        				if(temparr1[1]>='1'&&temparr1[1]<='9'){
        					score+=temparr1[1]-'0';
        				}
        				score+=10;
        			}
        		}
        		else return -1;
    		}
    		else if(templen==2){
        		char [] temparr=temp.toCharArray();
        		if(temparr[1]=='/'){    //sparse
        			String temp1=bArr[i+1];
            		int templen1=temp1.length();
            		char [] temparr1=temp1.toCharArray();
            		if(templen1==1){
            			score+=20;
            		}
            		else if(templen1==2){
            			if(temparr1[0]>='1'&&temparr1[0]<='9'){
            				score+=10+temparr1[0]-'0';
            			}
            			else{
            				score+=10;
            			}
            		}
            		else{
            			return -1;
            		}
        		}
        		else{
        			if(temparr[0]>='1'&&temparr[0]<='9'){
        				score+=temparr[0]-'0';
        			}
        			if(temparr[1]>='1'&&temparr[1]<='9'){
        				score+=temparr[1]-'0';
        			}
        		}
    		}
    		else{
    			return -1;//输入有误
    		}
    	}
    	String ten=bArr[9];    //第10格作特殊处理
		int tenlen=ten.length();
		char [] tenarr=ten.toCharArray();
		if(tenlen==1){
			String more=bArr[11];
			char [] morearr = more.toCharArray();
			int tempscore;
			if(morearr[0]=='X'){
				tempscore=10;
			}
			else if(morearr[0]>='1'&&morearr[0]<='9'){
				tempscore=morearr[0]-'0';
			}
			else{
				tempscore=0;
			}
			if(morearr[1]=='X'){
				tempscore+=10;
			}
			else if(morearr[1]>='1'&&morearr[1]<='9'){
				tempscore+=morearr[1]-'0';
			}
			else if(morearr[1]=='/'){
				tempscore=10;
			}
			score+=10+tempscore;
		}
		else if(tenlen==2){
			if(tenarr[1]=='/'){
				String more=bArr[11];
				char [] morearr = more.toCharArray();
				if(morearr[0]=='X'){
					score+=20;
				}
				else if(morearr[0]>='1'&&morearr[0]<='9'){
					score+=10+(morearr[0]-'0');
				}
				else{
					score+=10;
				}
			}
			else{
				if(tenarr[0]>='1'&&tenarr[0]<='9'){
					score+=tenarr[0]-'0';
				}
				if(tenarr[1]>='1'&&tenarr[1]<='9'){
					score+=tenarr[1]-'0';
				}
			}
		}
		else{
			return -1;
		}
        return score;
    }
    public static void main(String[] args) throws Exception{
    	Scanner s=new Scanner(System.in);
    	String bowlingcode=s.nextLine();
    	int result;
    	result=getBowlingScore(bowlingcode);
    	System.out.println(result);
    	if(result==-1){
    		System.out.println("输入有误");
    	}
    }
}
