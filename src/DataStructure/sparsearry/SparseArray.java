package DataStructure.sparsearry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SparseArray {
    public static void main(String[] args) throws IOException {
        //原数组
        int[][] a=new int[11][11];
        a[1][2]=1;
        a[3][4]=2;
        a[4][5]=2;
        for(int[] row:a){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //统计有多少个非0
        int sum=0;
        for (int i = 0; i < a.length; i++) {
            for(int j=0;j<a[i].length;j++){
                if(a[i][j]!=0){
                    sum++;
                }
            }
        }
        //根据非0数据的个数，new出稀疏矩阵
        int[][] sparseArray=new int[sum+1][3];
        sparseArray[0][0]=a.length;
        sparseArray[0][1]=a[1].length;
        sparseArray[0][2]=sum;
        //标记是第几个非0，
        int count=0;
        for (int i = 0; i < a.length; i++) {
            for(int j=0;j<a[i].length;j++){
                if(a[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=a[i][j];
                }
            }
        }
        System.out.println();
        //打印稀疏矩阵
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }
        System.out.println();
        //稀疏矩阵变回去
        int[][] b=new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            b[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }
        for (int[] row:b) {
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
//        //java IO将稀疏数组存入磁盘
//        File wirteFile=null;
//        Writer writer=null;
//        try {
//             wirteFile=new File("C:\\Users\\86188\\map.data");
//             writer=new FileWriter(wirteFile);
//            for (int i = 0; i < sparseArray.length; i++) {
//                writer.write(sparseArray[i][0]+"\t"+sparseArray[i][1]+"\t"+sparseArray[i][2]+"\n");
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            writer.close();
//        }

        System.out.println("==========");
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\86188\\map.data"));
        StringBuffer sb;
        List<StringBuffer> stringBuffers=new ArrayList<>();
        while (in.ready()) {
            sb = (new StringBuffer(in.readLine()));
            stringBuffers.add(sb);
        }
        int h=stringBuffers.size();
        int l=stringBuffers.get(0).toString().split("\t").length;
        int[][] c=new int[h][l];
        for (int i = 0; i < h; i++) {
            String[] item=stringBuffers.get(i).toString().split("\t");
            for (int j = 0; j < item.length; j++) {
                c[i][j]=Integer.valueOf(item[j]);
            }
        }
        System.out.println("输入从文件中读取的稀疏数组");
        for(int[] row:c){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
