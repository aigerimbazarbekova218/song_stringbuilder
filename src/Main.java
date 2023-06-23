import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Song song=new Song();
        song.setTitle("Without me");
        song.setAuthor("Halsey");
        song.setText(""+
               "Found you when your heart was broke\n"+
                "I filled your cup until it overflowed\n"+
                "Took it so far to keep you close (Keep you close)\n"+
                "I was afraid to leave you on your own(Ooh)'}");
        try(FileWriter fileWriter=new FileWriter("song.txt")) {
            fileWriter.write(song.getAuthor()+"\n");
            fileWriter.write(song.getTitle()+"\n");
            fileWriter.write(song.getText());
            System.out.println(song);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("____________________________________________");

           Song newSong=new Song();
        try (FileReader fileReader= new FileReader("song.txt")) {
            Scanner scanner=new Scanner(fileReader);
            int counter=0;
            StringBuilder stringBuilder=new StringBuilder();
            while (scanner.hasNext()){
                if(counter==0) {
                    newSong.setAuthor(scanner.nextLine());
                }else if(counter==1){
                    newSong.setTitle(scanner.nextLine());
                }else{
                    stringBuilder.append(scanner.nextLine()).append("\n");
                }
                counter++;
                newSong.setText(String.valueOf(stringBuilder));
            }
                System.out.println(newSong);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}