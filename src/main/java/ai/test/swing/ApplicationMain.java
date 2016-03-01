/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.test.swing;

/**
 *
 * @author tungdt
 */
public class ApplicationMain {
    private AddNew addNewForm;
    private ListView listViewForm;
    private static ApplicationMain instance = null;
    
    protected ApplicationMain() {
       // Exists only to defeat instantiation.
    }
    
   public static ApplicationMain getInstance() {
      if(instance == null) {
         instance = new ApplicationMain();
      }
      return instance;
   }

    public AddNew getAddNewForm() {
        if(addNewForm!=null){
            return addNewForm;
        }else{
            addNewForm = new AddNew();
            return addNewForm;
        }
    }

    public ListView getListViewForm() {
        if(listViewForm!=null){
            return listViewForm;
        }else{
            listViewForm = new ListView();
            return listViewForm;
        }
    }
   
   private void run(){
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                listViewForm = new ListView();
                listViewForm.setVisible(true);
            }
        });
   }
   
    public static void main( String[] args )
    {
        ApplicationMain applicationMain = ApplicationMain.getInstance();
        applicationMain.run();
    }
}

