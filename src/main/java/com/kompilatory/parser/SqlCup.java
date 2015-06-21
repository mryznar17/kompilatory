
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Sun Jun 21 11:58:55 CEST 2015
//----------------------------------------------------

package com.kompilatory.parser;

import java_cup.runtime.*;
import java.util.List;
import com.kompilatory.model.Tabela;
import java.util.LinkedList;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Sun Jun 21 11:58:55 CEST 2015
  */
public class SqlCup extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public SqlCup() {super();}

  /** Constructor which sets the default scanner. */
  public SqlCup(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public SqlCup(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\036\000\002\002\004\000\002\002\004\000\002\002" +
    "\003\000\002\004\004\000\002\005\011\000\002\005\006" +
    "\000\002\006\005\000\002\007\004\000\002\007\003\000" +
    "\002\007\003\000\002\010\005\000\002\010\004\000\002" +
    "\011\004\000\002\011\003\000\002\011\004\000\002\011" +
    "\003\000\002\011\007\000\002\011\006\000\002\011\004" +
    "\000\002\011\003\000\002\011\004\000\002\011\003\000" +
    "\002\011\004\000\002\011\003\000\002\011\004\000\002" +
    "\011\003\000\002\013\004\000\002\013\007\000\002\013" +
    "\011\000\002\013\011" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\073\000\004\005\004\001\002\000\004\006\013\001" +
    "\002\000\006\002\012\005\004\001\002\000\006\002\uffff" +
    "\005\uffff\001\002\000\004\030\010\001\002\000\006\002" +
    "\ufffe\005\ufffe\001\002\000\006\002\001\005\001\001\002" +
    "\000\004\002\000\001\002\000\006\004\014\007\015\001" +
    "\002\000\004\026\021\001\002\000\004\010\016\001\002" +
    "\000\004\011\017\001\002\000\004\004\020\001\002\000" +
    "\004\026\021\001\002\000\010\004\023\012\024\014\030" +
    "\001\002\000\004\030\ufffd\001\002\000\020\017\061\020" +
    "\055\021\056\022\060\023\054\024\057\025\053\001\002" +
    "\000\004\013\037\001\002\000\006\004\023\027\036\001" +
    "\002\000\006\004\ufff9\027\ufff9\001\002\000\006\004\ufff8" +
    "\027\ufff8\001\002\000\004\004\031\001\002\000\004\026" +
    "\032\001\002\000\004\004\033\001\002\000\004\027\034" +
    "\001\002\000\010\004\uffe6\027\uffe6\031\uffe6\001\002\000" +
    "\006\004\ufffa\027\ufffa\001\002\000\004\030\ufffb\001\002" +
    "\000\014\004\uffe7\014\040\026\041\027\uffe7\031\uffe7\001" +
    "\002\000\004\004\046\001\002\000\004\004\042\001\002" +
    "\000\004\031\043\001\002\000\004\004\044\001\002\000" +
    "\004\027\045\001\002\000\010\004\uffe4\027\uffe4\031\uffe4" +
    "\001\002\000\004\026\047\001\002\000\004\004\050\001" +
    "\002\000\004\027\051\001\002\000\010\004\uffe5\027\uffe5" +
    "\031\uffe5\001\002\000\010\004\ufff6\027\ufff6\031\074\001" +
    "\002\000\014\004\ufff2\012\024\014\030\027\ufff2\031\ufff2" +
    "\001\002\000\014\004\uffe8\012\024\014\030\027\uffe8\031" +
    "\uffe8\001\002\000\014\004\uffee\012\024\014\030\027\uffee" +
    "\031\uffee\001\002\000\014\004\uffec\012\024\014\030\027" +
    "\uffec\031\uffec\001\002\000\014\004\ufff4\012\024\014\030" +
    "\027\ufff4\031\ufff4\001\002\000\014\004\uffea\012\024\014" +
    "\030\027\uffea\031\uffea\001\002\000\004\026\062\001\002" +
    "\000\004\015\063\001\002\000\004\027\064\001\002\000" +
    "\014\004\ufff0\012\024\014\030\027\ufff0\031\ufff0\001\002" +
    "\000\010\004\ufff1\027\ufff1\031\ufff1\001\002\000\010\004" +
    "\uffeb\027\uffeb\031\uffeb\001\002\000\010\004\ufff5\027\ufff5" +
    "\031\ufff5\001\002\000\010\004\uffed\027\uffed\031\uffed\001" +
    "\002\000\010\004\uffef\027\uffef\031\uffef\001\002\000\010" +
    "\004\uffe9\027\uffe9\031\uffe9\001\002\000\010\004\ufff3\027" +
    "\ufff3\031\ufff3\001\002\000\006\004\ufff7\027\ufff7\001\002" +
    "\000\004\030\ufffc\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\073\000\010\002\004\004\005\005\006\001\001\000" +
    "\002\001\001\000\006\004\010\005\006\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\006\074" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\006\021\001\001\000\010\007\024\010\025" +
    "\013\026\001\001\000\002\001\001\000\004\011\051\001" +
    "\001\000\002\001\001\000\004\010\034\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\013\072\001\001\000\004\013" +
    "\071\001\001\000\004\013\070\001\001\000\004\013\067" +
    "\001\001\000\004\013\066\001\001\000\004\013\065\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\013\064\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$SqlCup$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$SqlCup$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$SqlCup$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



	Tabela tab = new Tabela();
	List<Tabela> tabele = new LinkedList<Tabela>();
	String nazwa;
	String typ;
	
	public Tabela getTabela()
	{
		return this.tab;
	}
	
	public List<Tabela> getTabele()
	{
		return this.tabele;
	}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$SqlCup$actions {
  private final SqlCup parser;

  /** Constructor */
  CUP$SqlCup$actions(SqlCup parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$SqlCup$do_action(
    int                        CUP$SqlCup$act_num,
    java_cup.runtime.lr_parser CUP$SqlCup$parser,
    java.util.Stack            CUP$SqlCup$stack,
    int                        CUP$SqlCup$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$SqlCup$result;

      /* select the action based on the action number */
      switch (CUP$SqlCup$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // key ::= PRIMARY KEY LBRACKET ID COMMA ID RBRACKET 
            {
              Object RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-3)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-3)).right;
		String var = (String)((java_cup.runtime.Symbol) CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-3)).value;
		int var2left = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).left;
		int var2right = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).right;
		String var2 = (String)((java_cup.runtime.Symbol) CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).value;
		 //TODO: zrobic i zwalidowac 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("key",9, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-6)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // key ::= PRIMARY KEY REFERENCES ID LBRACKET ID RBRACKET 
            {
              Object RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-3)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-3)).right;
		String var = (String)((java_cup.runtime.Symbol) CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-3)).value;
		int var2left = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).left;
		int var2right = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).right;
		String var2 = (String)((java_cup.runtime.Symbol) CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).value;
			 parser.typ = "primary key references "+var.toString()+"("+var2.toString()+")";	
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("key",9, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-6)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // key ::= REFERENCES ID LBRACKET ID RBRACKET 
            {
              Object RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-3)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-3)).right;
		String var = (String)((java_cup.runtime.Symbol) CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-3)).value;
		int var2left = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).left;
		int var2right = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).right;
		String var2 = (String)((java_cup.runtime.Symbol) CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).value;
		 parser.typ = "references "+var.toString()+"("+var2.toString()+")";	
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("key",9, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-4)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // key ::= PRIMARY KEY 
            {
              Object RESULT =null;
		 parser.typ = "primary key"; 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("key",9, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // var_type ::= SERIAL 
            {
              Object RESULT =null;
		 parser.typ = "serial"; 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("var_type",7, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // var_type ::= SERIAL key 
            {
              Object RESULT =null;
		 parser.typ = "serial "+parser.typ; 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("var_type",7, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // var_type ::= DATE 
            {
              Object RESULT =null;
		 parser.typ = "date"; 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("var_type",7, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // var_type ::= DATE key 
            {
              Object RESULT =null;
		 parser.typ = "date "+parser.typ; 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("var_type",7, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // var_type ::= TIMESTAMP 
            {
              Object RESULT =null;
		 parser.typ = "timestamp"; 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("var_type",7, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // var_type ::= TIMESTAMP key 
            {
              Object RESULT =null;
		 parser.typ = "timestamp "+parser.typ; 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("var_type",7, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // var_type ::= TEXT 
            {
              Object RESULT =null;
		  parser.typ = "text";  
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("var_type",7, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // var_type ::= TEXT key 
            {
              Object RESULT =null;
		 parser.typ = "text "+parser.typ; 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("var_type",7, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // var_type ::= VARCHAR LBRACKET INTEGER RBRACKET 
            {
              Object RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).right;
		Object var = (Object)((java_cup.runtime.Symbol) CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).value;
		 //parser.typ = "varchar("+var.toString()+")"; 
																																												parser.typ = "varchar("+var+")"; 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("var_type",7, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-3)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // var_type ::= VARCHAR LBRACKET INTEGER RBRACKET key 
            {
              Object RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-2)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-2)).right;
		Object var = (Object)((java_cup.runtime.Symbol) CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-2)).value;
		 //parser.typ = "varchar("+var.toString()+") "+parser.typ; 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("var_type",7, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-4)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // var_type ::= REAL_TYPE 
            {
              Object RESULT =null;
		  parser.typ = "real"; 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("var_type",7, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // var_type ::= REAL_TYPE key 
            {
              Object RESULT =null;
		 parser.typ = "real "+parser.typ; 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("var_type",7, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // var_type ::= INTEGER_TYPE 
            {
              Object RESULT =null;
		 parser.typ = "integer"; 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("var_type",7, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // var_type ::= INTEGER_TYPE key 
            {
              Object RESULT =null;
		 parser.typ = "integer "+parser.typ; 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("var_type",7, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // variable ::= ID var_type 
            {
              Object RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).right;
		String var = (String)((java_cup.runtime.Symbol) CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).value;
		 parser.nazwa=var.toString(); parser.tab.getAtrybuty().put(parser.nazwa,parser.typ); 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("variable",6, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // variable ::= ID var_type COMMA 
            {
              Object RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-2)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-2)).right;
		String var = (String)((java_cup.runtime.Symbol) CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-2)).value;
		 parser.nazwa=var.toString(); parser.tab.getAtrybuty().put(parser.nazwa,parser.typ); 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("variable",6, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-2)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // mid ::= key 
            {
              Object RESULT =null;
		  
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("mid",5, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // mid ::= variable 
            {
              Object RESULT =null;
		  
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("mid",5, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // mid ::= mid variable 
            {
              Object RESULT =null;

              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("mid",5, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // dec ::= LBRACKET mid RBRACKET 
            {
              Object RESULT =null;

              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("dec",4, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-2)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // def ::= CREATE TABLE ID dec 
            {
              String RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).right;
		String var = (String)((java_cup.runtime.Symbol) CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).value;
		 parser.tab=new Tabela(); parser.tab.setNazwa(var.toString()); 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("def",3, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-3)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // def ::= CREATE TABLE IF NOT EXISTS ID dec 
            {
              String RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).right;
		String var = (String)((java_cup.runtime.Symbol) CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).value;
		  RESULT = "test3000";
															System.out.println(var.toString()+"costam"); 
															 parser.tab.setNazwa(var.toString()); 
															parser.tabele.add(parser.tab);
															parser.tab=new Tabela();
															
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("def",3, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-6)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // new_table ::= def APOSTROPHE 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).value;
		 RESULT=a; 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("new_table",2, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // input ::= new_table 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$SqlCup$stack.peek()).value;
		 RESULT=a; 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("input",0, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= input EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).value;
		RESULT = start_val;
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$SqlCup$parser.done_parsing();
          return CUP$SqlCup$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // input ::= input new_table 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)).value;
		 RESULT=a; 
              CUP$SqlCup$result = parser.getSymbolFactory().newSymbol("input",0, ((java_cup.runtime.Symbol)CUP$SqlCup$stack.elementAt(CUP$SqlCup$top-1)), ((java_cup.runtime.Symbol)CUP$SqlCup$stack.peek()), RESULT);
            }
          return CUP$SqlCup$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

