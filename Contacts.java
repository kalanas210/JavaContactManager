class Contact{
    private String id;
    private String name;
    private String phoneNumber;
    private String companyName;
    private double salary;
    private String birthday;

    public Contact(String id,String name,String phoneNumber,String companyName,double salary,String birthday){ // constructor

        this.id=id;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.companyName=companyName;
        this.salary=salary;
        this.birthday=birthday;

    }

    public void setId(String id){ // setter for id
        this.id=id;
    }
    public void setName(String name){ // setter for name
        this.name=name;
    }
    public void setPhoneNumber(String phoneNumber){ // setter for number 
        this.phoneNumber=phoneNumber;
    }
    public void setCompanyName(String companyName){ // setter for company name
        this.companyName=companyName;
    }
    public void setSalary(double salary){ // setter for salary
        this.salary=salary;
    }
    public void setBirthday(String birthday){ // setter for birthday
        this.birthday=birthday;
    }

    public String getId(){ // get id
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getCompanyName(){
        return companyName;
    }
    public double getSalary(){
        return salary;
    }
    public String getBirthday(){
        return birthday;
    }
    


}

