import java.util.Scanner;
public class Main{
    public static Scanner in=new Scanner(System.in);
    public static void main(String[] args){
        int N=in.nextInt(); //вводим количество строк массива
        double [][]a=new double[N][]; //задаем двумерный массив N строк
        for(int i=0;i<a.length;i++){ //проходимся по строкам массива
            int M=in.nextInt(); //задаем количество элементов в строке
            a[i]=new double[M]; //задаем строку массива длиной M
            for(int j=0;j<a[i].length;j++){ //проходимя по каждому элементу строки
                a[i][j]=in.nextDouble(); //задаем каждый элемент строки
            }
        }
        System.out.println("Начальный массив");
        for(int i=0;i<a.length;i++){ //проходимся по строкам массива
            for(int j=0;j<a[i].length;j++){ //проходимя по каждому элементу строки
                System.out.print(a[i][j]+ " "); //выводим каждый элемент строки
            }
            System.out.println();
        }


        for(int i=0;i<a.length-1;i++){ //берем строку массива, единицу вычитаем тк j=i+1
            for(int j=i+1;j<a.length;j++){ //берем другую строку массива
                int k1=0; //инициализируем k1 для подсчета отрицательных элементов взятой строки
                int k2=0; //инициализируем k2 для подсчета отрицательных элементов другой строки
                double sum1=0; //инициализируем sum1 для подсчета суммы неотрицательных элементов взятой строки
                double sum2=0; //инициализируем sum2 для подсчета суммы неотрицательных элементов другой строки
                //подсчет отрицательных и положительных чисел в строках
                for (int k=0;k<a[i].length;k++){ //берем элемент строки i с индексом к
                    if (a[i][k]<0){ // проверяем, отрицательный ли элемент
                        k1+=1; // если отрицательный, то прибавляем 1 к к1
                    }
                    else {
                        sum1+=a[i][k]; //если неотрицательный, то прибавляем элемент к общей сумме неотрицательных в строке
                    }
                }
                for (int k=0;k<a[j].length;k++){ //берем элемент строки j с индексом к
                    if (a[j][k]<0){ // проверяем, отрицательный ли элемент
                        k2+=1; // если отрицательный, то прибавляем 1 к к2
                    }
                    else{
                        sum2+=a[j][k]; //если неотрицательный, то прибавляем элемент к общей сумме неотрицательных в строке
                    }
                }
                //сравнение количества отрицательных чисел
                if (k1>k2){ //проверяем условие что k1 больше k2
                    //обмен строк
                    double[] z=a[i];
                    a[i]=a[j];
                    a[j]=z;
                } else if(k1==k2){
                    //сравнение суммы положительных чисел
                    if(sum1>sum2){ //проверяем условие что sum1 больше sum2
                        //обмен строк
                        double[] z=a[i];
                        a[i]=a[j];
                        a[j]=z;
                    }
                }
            }
        }


        System.out.println("Сортировка массива по возрастанию количества отрицательных чисел в строке");
        //выводим получивщийся массив по обычному алгоритму
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]+ " ");
            }
            System.out.println();
        }

        int maxStr=0; //инициализируем maxStr для обозначения индекса строки максимального элемента массива
        int maxStol=0; //инициализируем maxStol для обозначения индекса максимального элемента массива в строке
        double maxi=a[0][0]; //возьмем первый элемент массива как максимальный
        for (int i=0;i<a.length;i++){ //проходимся по строкам массива
            for (int j=0;j<a[i].length;j++){ //проходимся по элементам строки
                if (a[i][j]>maxi){ //проверяем больше ли взятый элемени максимального элемента
                    //если условие выполняется, то:
                    maxi=a[i][j]; //взятый элемент становится максимальным
                    maxStr=i; //записываем строку максимального элемента
                    maxStol=j; //записываем индекс максимального элемента в строке
                }
            }
        }
        System.out.println("Максимальный элемент: " + maxi);
        System.out.println("Индексы максимального элемента: [" + maxStr + ", " + maxStol + "]");

        //найдем максимальную длину строки
        int maxL=0; //инициализируем maxL для обозначения максимальной длины
        for (int i=0;i<a.length;i++){ //проходимся по строкам массива
            if (a[i].length>maxL){ //проверяем что длина взятой строки больше максимальной длины строки
                // если да, то:
                maxL=a[i].length; //записываем длину взятой строки как максимальную
            }
        }

        System.out.println("Вывод массива в виде марицы");
        for (int i=0; i<a.length;i++){ //проходимся по строкам массива
            for (int j=0; j<a[i].length;j++){ //проходимся по элементам строк
                System.out.print(a[i][j] + " "); //выводим элементы строки
            }
            for (int j=a[i].length; j<maxL;j++){ /* заполняем оставшуюся строку символами "*" до тех пор,
             пока не дойдем до длины максимальной строки*/
                System.out.print("* ");
            }
            System.out.println();
        }
         //заменяем числа массива на обратные
        for (int i=0;i<a.length;i++){ //проходимся по каждой строке массива
            for (int j=0;j<a[i].length;j++){ //проходимся по каждому элементу в строке
                if (a[i][j]!=0) {//проверяем что элемент не равен 0, чтобы не было деления на 0
                    a[i][j]=1/a[i][j]; //заменяем элемент на обратный ему
                }
            }
        }
        System.out.println("Массив после замены всех чисел на обратные значения");
        //выводим получивщийся массив по обычному алгоритму
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[i].length;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}