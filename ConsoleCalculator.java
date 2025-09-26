import java.util.Scanner;
class ConsoleCalculator{

    public static double add(double a,double b){
        return a+b;
    }

    public static double sub(double a,double b){
        return a-b;
    }

    public static double mul(double a,double b){
        return a*b;
    }

    public static double div(double a,double b){
        if(b==0){
            System.out.println("Error...Cannot divide by zero");
            return Double.NaN;
        }
        return a/b;
    }
        public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        boolean ContinueCalc=true;
        while(ContinueCalc){
            System.out.println("Console Calculator");
            System.out.println("1.Addition");
            System.out.println("2.Subtraction");
            System.out.println("3.Multiplication");
            System.out.println("4.Division");
            System.out.print("Choose an operation(1-5):");
            int choice=sc.nextInt();
            if(choice==5){
                ContinueCalc=false;
                System.out.println("Exiting.....Thank You!");
                break;
            }
            
            System.out.println("Enter the first Number");
            double num1=sc.nextDouble();
            System.out.println("Enter the second Number");
            double num2=sc.nextDouble();
            
            double result=0;
            switch (choice) {
                case 1:
                result=add(num1,num2);
                System.out.println("Result: "+result);
                break;

                case 2:
                result=sub(num1,num2);
                System.out.println("Result: "+result);
                break;

                case 3:
                result=mul(num1,num2);
                System.out.println("Result: "+result);
                break;

                case 4:
                result=div(num1,num2);
                System.out.println("Result: "+result);
                if(Double.isNaN(result)){
                    System.out.println("Result: "+result);
                }
                break;
                
                
                default:
                System.out.println("Invalid choice!  Please select 1-5.");
              
            }
        }
        
        
        
    }
}