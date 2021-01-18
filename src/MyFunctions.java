import java.util.List;

public class MyFunctions {
    //运算符指令
    //目前只支持int，double
    public static void operatorInstructions(TokenType calculate, List<Instruction> instructions, String type) throws Exception{
        Instruction instruction;
        switch (calculate) {
            //+
            case PLUS:
                if(type.equals("int"))
                    instruction = new Instruction("add.i", null);
                else if(type.equals("double"))
                    instruction = new Instruction("add.f", null);
                else
                    throw new Exception();
                instructions.add(instruction);
                break;
            //-
            case MINUS:
                if(type.equals("int"))
                    instruction = new Instruction("sub.i", null);
                else if(type.equals("double"))
                    instruction = new Instruction("sub.f", null);
                else
                    throw new Exception();
                instructions.add(instruction);
                break;
            //*
            case MUL:
                if(type.equals("int"))
                    instruction = new Instruction("mul.i", null);
                else if(type.equals("double"))
                    instruction = new Instruction("mul.f", null);
                else
                    throw new Exception();
                instructions.add(instruction);
                break;
            ///
            case DIV:
                if(type.equals("int"))
                    instruction = new Instruction("div.i", null);
                else if(type.equals("double"))
                    instruction = new Instruction("div.f", null);
                else
                    throw new Exception();
                instructions.add(instruction);
                break;
            //==
            case EQ:
                if(type.equals("int"))
                    instruction = new Instruction("cmp.i", null);
                else if(type.equals("double"))
                    instruction = new Instruction("cmp.f", null);
                else
                    throw new Exception();
                instructions.add(instruction);

                instruction = new Instruction("not", null);
                instructions.add(instruction);
                break;
            //!=
            case NEQ:
                if(type.equals("int"))
                    instruction = new Instruction("cmp.i", null);
                else if(type.equals("double"))
                    instruction = new Instruction("cmp.f", null);
                else
                    throw new Exception();
                instructions.add(instruction);
                break;
            //<
            case LT:
                if(type.equals("int"))
                    instruction = new Instruction("cmp.i", null);
                else if(type.equals("double"))
                    instruction = new Instruction("cmp.f", null);
                else
                    throw new Exception();
                instructions.add(instruction);

                instruction = new Instruction("set.lt", null);
                instructions.add(instruction);
                break;
            //>
            case GT:
                if(type.equals("int"))
                    instruction = new Instruction("cmp.i", null);
                else if(type.equals("double"))
                    instruction = new Instruction("cmp.f", null);
                else
                    throw new Exception();
                instructions.add(instruction);

                instruction = new Instruction("set.gt", null);
                instructions.add(instruction);
                break;
            //<=
            case LE:
                if(type.equals("int"))
                    instruction = new Instruction("cmp.i", null);
                else if(type.equals("double"))
                    instruction = new Instruction("cmp.f", null);
                else
                    throw new Exception();
                instructions.add(instruction);

                instruction = new Instruction("set.gt", null);
                instructions.add(instruction);
                instruction = new Instruction("not", null);
                instructions.add(instruction);
                break;
            //>=
            case GE:
                if(type.equals("int"))
                    instruction = new Instruction("cmp.i", null);
                else if(type.equals("double"))
                    instruction = new Instruction("cmp.f", null);
                else
                    throw new Exception();
                instructions.add(instruction);

                instruction = new Instruction("set.lt", null);
                instructions.add(instruction);
                instruction = new Instruction("not", null);
                instructions.add(instruction);
                break;
            default:
                break;
        }

    }

    /**
     * 根据函数名字得到函数存储的id
     * @param name
     * @param functionTable
     * @return
     */
    public static int getFunctionId(String name, List<Function> functionTable){
        for (int i=0 ; i<functionTable.size(); i++) {
            if (functionTable.get(i).getName().equals(name)) return i;
        }
        return -1;
//        for (Function function : functionTable) {
//            if (function.getName().equals(name)) return function.getId();
//        }
//        return -1;
    }

    /**
     * 判断函数有没有返回值
     * @param name
     * @param functionTable
     * @return
     */
    public static boolean functionHasReturn(String name, List<Function> functionTable) {
        //如果是库函数
        if (name.equals("getint") || name.equals("getdouble") || name.equals("getchar"))
                return true;
        //如果是自定义函数
        for (Function function : functionTable) {
            if (function.getName().equals(name)) {
                if (function.getRetType() == 1) return true;
            }
        }
        return false;
    }
}