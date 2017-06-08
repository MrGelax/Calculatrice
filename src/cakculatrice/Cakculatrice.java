/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cakculatrice;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Pedro
 */
public class Cakculatrice extends Application{

    
    private String[] tab={"1","2","3","4","5","6","7","8","9",".","0","=","C","+","-","*","/"};
    private Button [] tabBut=new Button [tab.length];
    private TextField ecran=new TextField("");
    private Double res=0.0;
    private VBox root=new VBox(10);
    private HBox cent=new HBox(10);
    private VBox op=new VBox(10);
    private GridPane number=new GridPane();
    private String signe="";
    
    
    //public void setList(ArrayList <Button> l){this.tab=l;}
    public Button[] getTabBut(){return this.tabBut;}
    
    public TextField getEcran(){return this.ecran;}
    
    public void setRes(Double r){this.res=r;}
    public Double getRes(){return this.res;}
    
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage stage){
        
        
        this.ecran.setPrefSize(220, 20);
        this.ecran.setPromptText("0");
        iniTab();
        this.cent.getChildren().addAll(this.number,this.op);
        this.root.getChildren().addAll(this.getEcran(),this.cent);
        Scene sc=new Scene(this.root);
        stage.setScene(sc);
        stage.show();
        
    }
    public void iniTab(){
        for(Integer i=0;i<this.tab.length;i++) {
           tabBut[i]=new Button(this.tab[i]);
           tabBut[i].setPrefSize(50,40);
           this.number.setHgap(10);
           this.number.setVgap(10);
            switch(i){
               case 12:System.out.println("OP : "+this.tabBut[i].getText());
               this.tabBut[i].setOnAction(e-> actionListenerOp(12));
               this.op.getChildren().add(this.tabBut[i]);break;
               case 13:this.tabBut[i].setOnAction(e-> actionListenerOp(13));this.op.getChildren().add(this.tabBut[i]);break;
               case 14:this.tabBut[i].setOnAction(e-> actionListenerOp(14));this.op.getChildren().add(this.tabBut[i]);break;
               case 15:this.tabBut[i].setOnAction(e-> actionListenerOp(15));this.op.getChildren().add(this.tabBut[i]);break;
               case 16:this.tabBut[i].setOnAction(e-> actionListenerOp(16));this.op.getChildren().add(this.tabBut[i]);break;
               default:
                        case 0:this.tabBut[i].setOnAction(e->actionListenerNum(0));this.number.add(this.tabBut[i],i,0);break;
                        case 1:this.tabBut[i].setOnAction(e->actionListenerNum(1));this.number.add(this.tabBut[i],i,0);break;
                        case 2:this.tabBut[i].setOnAction(e->actionListenerNum(2));this.number.add(this.tabBut[i],i,0);break;
                        case 3:this.tabBut[i].setOnAction(e->actionListenerNum(3));this.number.add(this.tabBut[i],i-3,1);break;
                        case 4:this.tabBut[i].setOnAction(e->actionListenerNum(4));this.number.add(this.tabBut[i],i-3,1);break;
                        case 5:this.tabBut[i].setOnAction(e->actionListenerNum(5));this.number.add(this.tabBut[i],i-3,1);break;
                        case 6:this.tabBut[i].setOnAction(e->actionListenerNum(6));this.number.add(this.tabBut[i],i-6,2);break;
                        case 7:this.tabBut[i].setOnAction(e->actionListenerNum(7));this.number.add(this.tabBut[i],i-6,2);break;
                        case 8:this.tabBut[i].setOnAction(e->actionListenerNum(8));this.number.add(this.tabBut[i],i-6,2);break;
                        case 9:this.tabBut[i].setOnAction(e->actionListenerNum(9));this.number.add(this.tabBut[i],i-9,3);break;
                        case 10:this.tabBut[i].setOnAction(e->actionListenerNum(10));this.number.add(this.tabBut[i],i-9,3);break;
                        case 11:this.tabBut[i].setOnAction(e->actionListenerNum(11));this.tabBut[i].setOnAction(e->actionListenerEquals());this.number.add(this.tabBut[i],i-9,3);break;
           }
        }
    }
    public void actionListenerOp(Integer indice){
        if (indice==12)
            this.ecran.clear();
        else
            this.signe=this.tabBut[indice].getText();
            this.res=Double.parseDouble("0"+this.ecran.getText());
            this.ecran.clear();
    }
    public void actionListenerEquals(){
        this.res+=Double.parseDouble(this.ecran.getText());
        this.ecran.setText(""+this.res);
    }
    public void actionListenerNum(Integer indice){
        this.ecran.setText(this.ecran.getText()+this.tabBut[indice].getText());
    }
    
    
    public void calcu(double op1,double op2,char signe){
        switch (signe){
            case '+':this.setRes(op1+op2);break;
            case '-':this.setRes(op1-op2);break;
            case '*':this.setRes(op1*op2);break;
            case '/':this.setRes(op1/op2);break;
        }
    }
}
