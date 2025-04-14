import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ContactController {

	private static JTable tblCustomerDetails;
	private static DefaultTableModel dtm;

    public static int contactID = 1;

    public static String setContactID(){
        
        return "C"+String.format("%04d", contactID);

    }

    public static boolean addContacts(Contact contacts){

        ContactList contactList = DBConnection.getInstance().getContactList();
        contactList.add(contacts);
        return true;
    }

    public static boolean deleteContacts(int index){

        ContactList contactList = DBConnection.getInstance().getContactList();
        contactList.remove(index);
        return true;
    }

    public static boolean isValidPhoneNumber(String phoneNumber){
        if(phoneNumber.length()==10 && phoneNumber.charAt(0)=='0'){
            for(int i=1; i<phoneNumber.length(); i++){
                if(!Character.isDigit(phoneNumber.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;

    }

    public static boolean isValidSalary(double salary){
        return salary>0;
    }
    // -------------------BIRTHDAY VALIDATION----------------
	public static boolean isValidBirthday(String birthday){
        String y=birthday.substring(0,4);
		int year=Integer.parseInt(y);
		String m=birthday.substring(5,7);
		int month=Integer.parseInt(m);
		String d=birthday.substring(8,10);
		int day=Integer.parseInt(d);
		LocalDate currentDate = LocalDate.now();
		int currentMonthValue = currentDate.getMonthValue();
		int currentYear=currentDate.getYear();    
		int currentMonthDate=currentDate.getDayOfMonth();
			
		if(year%4!=0 & month==2){
			if(day>28){
				return false;
			}else{
				return true;
			}
		}
		if(year%4==0 & month==2){
			if(day>29){
				return false;
			}else{
				return true;
			}
		}
		if(month==4 || month==6 || month==9 || month==11){
			if(day>30){
				return false;					
			}
		}
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
			if(day>31){
				return false;
			}	
		}
		if(month>12){
			return false;
		}
		if(year<currentYear){
			return true;
			}else if(year==currentYear){
									
				if(month>currentMonthValue){
					return true;
				}else if(month==currentMonthValue){
									
					if(day<=currentMonthDate){
						return true;
					}
				}
			}
					return false;
    }


    public static int searchContact(String nameOrphone){

        ContactList contactList = DBConnection.getInstance().getContactList();
        return contactList.searchByNameOrPhoneNumber(nameOrphone);
    }

    public static boolean UpdateContact(String id,String name,String phone,String company,double salary,String birthday,int index){
        ContactList contactList = DBConnection.getInstance().getContactList();
        contactList.get(index).setId(id);
        contactList.get(index).setName(name);
        contactList.get(index).setPhoneNumber(phone);
        contactList.get(index).setCompanyName(company);
        contactList.get(index).setSalary(salary);
        contactList.get(index).setBirthday(birthday);
        return true;
    }

	public static JScrollPane sortingByName(){
        ContactList contactList = DBConnection.getInstance().getContactList();
        String tempArray[]=new String[contactList.size()];
        for(int i=0;i<tempArray.length;i++){
            tempArray[i]=contactList. get(i).getName();
        }
        for(int i=0;i<tempArray.length;i++){
            for(int j=i+1;j<tempArray.length;j++){
                if(tempArray[i].compareTo(tempArray[j])>0){
                    String temp=tempArray[i];
                    tempArray[i]=tempArray[j];
                    tempArray[j]=temp;
                }
            }
        }


        String[] columnName={"Customer ID", "Name", "Phone", "Company Name", "Salary", "Birthday"};
        dtm=new DefaultTableModel(columnName,0);
        tblCustomerDetails=new JTable(dtm);
        JTableHeader header = tblCustomerDetails.getTableHeader();
        header.setBackground(new Color(144, 158, 174));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("",1,15));
        tblCustomerDetails.setFont(new Font("",1,15));
        JScrollPane tablePane=new JScrollPane(tblCustomerDetails);
		tablePane.setPreferredSize(new Dimension(650, 200));

        for(int i=0;i<tempArray.length;i++){
            for(int j=0;j<contactList.size();j++){
                if(tempArray[i]==contactList.get(j).getName()){
                    //System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",contactList.get(j).getId(),get(j).getName(),get(j).getPhoneNumber(),get(j).getCompanyName(),get(j).getSalary(),get(j).getBirthday());
                    Object[] rowData={contactList.get(j).getId(),contactList.get(j).getName(),contactList.get(j).getPhoneNumber(),contactList.get(j).getCompanyName(),contactList.get(j).getSalary(),contactList.get(j).getBirthday()};
                    dtm.addRow(rowData);
                }
            }
        }

        return tablePane;

       
    }

	

	public static JScrollPane sortingBySalary(){

        ContactList contactList = DBConnection.getInstance().getContactList();
        double tempArray[]=new double[contactList.size()];
        for(int i=0;i<tempArray.length;i++){
            tempArray[i]=contactList.get(i).getSalary();
        }
        for(int i=0;i<tempArray.length;i++){
            for(int j=i+1;j<tempArray.length;j++){
                if(tempArray[i]>tempArray[j]){
                    double temp=tempArray[i];
                    tempArray[i]=tempArray[j];
                    tempArray[j]=temp;
                }
            }
        }
    String[] columnName={"Customer ID", "Name", "Phone", "Company", "Salary", "Birthday"};
	dtm=new DefaultTableModel(columnName,0);
	tblCustomerDetails=new JTable(dtm);
	JTableHeader header = tblCustomerDetails.getTableHeader();
	header.setBackground(new Color(144, 158, 174));
	header.setForeground(Color.WHITE);
	header.setFont(new Font("",1,15));
	tblCustomerDetails.setFont(new Font("",1,15));
	JScrollPane tablePane=new JScrollPane(tblCustomerDetails);
	tablePane.setPreferredSize(new Dimension(650, 200));

        for(int i=0;i<tempArray.length;i++){
            for(int j=0;j<contactList.size();j++){
                if(tempArray[i]==contactList. get(j).getSalary()){
                    //System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",contactList.get(j).getId(),get(j).getName(),get(j).getPhoneNumber(),get(j).getCompanyName(),get(j).getSalary(),get(j).getBirthday());
                    Object[] rowData={contactList.get(j).getId(),contactList.get(j).getName(),contactList.get(j).getPhoneNumber(),contactList.get(j).getCompanyName(),contactList.get(j).getSalary(),contactList.get(j).getBirthday()};
                    dtm.addRow(rowData);
                }
            }
        }


        return tablePane;

    }

    public static JScrollPane sortingByBirthday(){

		ContactList contactList = DBConnection.getInstance().getContactList();

        String tempArray[]=new String[contactList.size()];
        for(int i=0;i<tempArray.length;i++){
            tempArray[i]=contactList.get(i).getBirthday();
        }
        for(int i=0;i<tempArray.length;i++){
            for(int j=0;j<tempArray.length;j++){
                if(tempArray[i].compareTo(tempArray[j])>0){
                    String temp=tempArray[i];
                    tempArray[i]=tempArray[j];
                    tempArray[j]=temp;
                }
            }
        }

        String[] columnName={"Customer ID", "Name", "Phone", "Company Name", "Salary", "Birthday"};
        dtm=new DefaultTableModel(columnName,0);
        tblCustomerDetails=new JTable(dtm);
        JTableHeader header = tblCustomerDetails.getTableHeader();
        header.setBackground(new Color(144, 158, 174));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("",1,15));
        tblCustomerDetails.setFont(new Font("",1,15));  
        JScrollPane tablePane=new JScrollPane(tblCustomerDetails);
        tablePane.setPreferredSize(new Dimension(650, 200));

        for(int i=0;i<tempArray.length;i++){
            for(int j=0;j<contactList.size();j++){
                if(tempArray[i].equals(contactList.get(j).getBirthday())){
                    //System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",contactList.get(j).getId(),get(j).getName(),get(j).getPhoneNumber(),get(j).getCompanyName(),get(j).getSalary(),get(j).getBirthday());
                    Object[] rowData={contactList.get(j).getId(),contactList.get(j).getName(),contactList.get(j).getPhoneNumber(),contactList.get(j).getCompanyName(),contactList.get(j).getSalary(),contactList.get(j).getBirthday()};
                    dtm.addRow(rowData);
                }
            }
        }

        return tablePane;

    }
    
}
