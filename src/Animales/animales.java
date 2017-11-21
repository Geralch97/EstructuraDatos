package Animales;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

public class animales {

    
    LinkedList<String[]> data;
    String[][] mainTree;
    int fileLength;

    public animales() {
        this.data = new LinkedList<String[]>();

    }

    public String[][] read() {
        String line = null;
        int counter = 0;
        try {
            FileReader fileReader
                    = new FileReader("C:\\Users\\Home\\Documents\\NetBeansProjects\\eDatos\\src\\ArbolBinarioGen\\animales.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null) {
                String[] arr = new String[line.length()];
                arr = line.split("#");
                counter++;
                data.offer(arr);
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file");
        }
        String[][] bigArr = new String[counter][];
        int c2 = 0;
        while (!data.isEmpty()) {
            bigArr[c2] = data.pop();
            c2++;
        }
        this.fileLength = c2;
        return bigArr;

    }

    public void learn(int level, int branch, String question, String answer) {
        int currentLvl = level - 1;
        int currentBranch = branch / 2;
        String wrongAns = this.mainTree[currentLvl][currentBranch];
        String[][] newArr = new String[this.fileLength + 1][(int) Math.pow(2, level)];
        for (int i = 0; i < this.fileLength; i++) {
            newArr[i] = this.mainTree[i];
        }
        System.out.println(level + "," + branch);
        newArr[currentLvl][currentBranch] = question;
        newArr[level][branch] = wrongAns;
        newArr[level][currentBranch * 2 + 1] = answer;
        System.out.println(Arrays.deepToString(newArr));
        this.mainTree = newArr;

        PrintWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new PrintWriter("C:\\Users\\Home\\"
                    + "Documents\\NetBeansProjects\\eDatos\\src\\ArbolBinarioGen\\animales.txt");
            bw = new BufferedWriter(fw);
            for(int i=0;i<this.mainTree.length;i++){
                for(int j=0;j<this.mainTree[i].length;j++){
                    bw.write(this.mainTree[i][j]+"#");
                }
                bw.write("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }
}