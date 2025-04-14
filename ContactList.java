class ContactList{
    private Node start;

    public void add(Contact contact){
        Node n1 = new Node(contact);
        if(start==null){
			start=n1;
		}else{
			Node lastNode=start;
			while(lastNode.next!=null){
				lastNode=lastNode.next;
			}
			lastNode.next=n1; 
		}

    }

    public boolean isEmpty(){
		return start==null;
	}

    public boolean isValidIndex(int index){
        return index >=0 & index <size();
    }

    public int size(){
		int count=0;
		Node temp=start;
		while(temp!=null){
			count++;
			temp=temp.next;
		}
		return count;
	}

    public void remove(int index){
		if(index>=0 && index<size()){
			if(index==0){
				start=start.next;
			}else{
				int count=0;
				Node temp=start;
				while(count<index-1){
					count++;
					temp=temp.next;
				}
				temp.next=temp.next.next;
			}
		}
		
	}

    public Contact get(int index){
		if(isValidIndex(index)){
			Node temp=start;
			int count=0;
			while(count<index){
				count++;
				temp=temp.next;
			}
			return temp.contact; 
		}
        return null;
		
	}

    public int searchByNameOrPhoneNumber(String nameOrPhone){
		int index=0;
		Node temp=start;
		while(temp!=null){
			if(temp.contact.getName().equals(nameOrPhone)|temp.contact.getPhoneNumber().equals(nameOrPhone)){
				return index;
			}
			index++;
			temp=temp.next;
		}
		return -1;
	}

    public void sortingByName(){
        
        String tempArray[]=new String[size()];
        for(int i=0;i<tempArray.length;i++){
            tempArray[i]=get(i).getName();
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
        for(int i=0;i<tempArray.length;i++){
            for(int j=0;j<size();j++){
                if(tempArray[i].equals(get(j).getName())){
                    System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",get(j).getId(),get(j).getName(),get(j).getPhoneNumber(),get(j).getCompanyName(),get(j).getSalary(),get(j).getBirthday());
                }
            }
        }
       
    }

    public void sortingBySalary(){
        
        double tempArray[]=new double[size()];
        for(int i=0;i<tempArray.length;i++){
            tempArray[i]=get(i).getSalary();
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
        for(int i=0;i<tempArray.length;i++){
            for(int j=0;j<size();j++){
                if(tempArray[i]==get(j).getSalary()){
                    System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",get(j).getId(),get(j).getName(),get(j).getPhoneNumber(),get(j).getCompanyName(),get(j).getSalary(),get(j).getBirthday());
                }
            }
        }

    }

    //-------------------------BIRTHDAY SORT---------------------------
    public void sortingByBirthday(){

        String tempArray[]=new String[size()];
        for(int i=0;i<tempArray.length;i++){
            tempArray[i]=get(i).getBirthday();
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
        for(int i=0;i<tempArray.length;i++){
            for(int j=0;j<size();j++){
                if(tempArray[i].equals(get(j).getBirthday())){
                    System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",get(j).getId(),get(j).getName(),get(j).getPhoneNumber(),get(j).getCompanyName(),get(j).getSalary(),get(j).getBirthday());
                }
            }
        }

    }
    class Node{
        private Contact contact;
        private Node next;

        Node(Contact contact){
            this.contact=contact;
        }
    }
}