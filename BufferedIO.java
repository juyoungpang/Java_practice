import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BufferedIO {
    //throws IOException 필수
    public static void main(String[] args) throws IOException{
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
        String s = br.readLine(); //String 읽어오기
        int i = Integer.parseInt(br.readLine()); //int 읽어오기

        //공백 단위로 String 쪼개기 - StringTokenizer
        //단어(공백)숫자 형태로 되어있는 경우 (예: 주영 102)
        StringTokenizer tkn  = new StringTokenizer(br.readLine());
        String a = tkn.nextToken();
        int b = Integer.parseInt(tkn.nextToken());

        //BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //선언
        bw.write(s+"\n");   //출력
        bw.write(i+"\n"+a+", "+b); //출력
        bw.newLine(); //개행 역할
        bw.flush();   //남아있는 데이터를 모두 출력시킴
        bw.close();   //스트림을 닫음
    }
}
