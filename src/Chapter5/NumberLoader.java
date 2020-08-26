package Chapter5;

public class NumberLoader {
    public static void main(String[]args){
        if(args.length!=2) error("invalid number of arguments");
        try{
            //REFLECTIVE OPERATIONS
            Class<?> numberClass = Class.forName("java.lang."+args[0]);
            Number number = (Number) numberClass.getDeclaredMethod("valueOf", String.class).invoke(null, args[1]);
            System.out.println(number + " is a number of type " + number.getClass().getName());

        }catch(ReflectiveOperationException e){ error("Invalid number type");}
        catch(NumberFormatException e){error("invalid number format");}

    }

    public static void error(String errorMessage){
        System.out.println(errorMessage);
        System.exit(1);
    }

}
