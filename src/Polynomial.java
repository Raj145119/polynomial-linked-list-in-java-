import java.util.*;
public class Polynomial extends AbstractPolynomial {

   public Polynomial(String s) {
	 String s1New = s.replaceAll("-", "+-");
	 String s2New = s1New.replaceAll("- ", "-");
	 String[] arr = s2New.split("\\+");
	
	 double coefficient;
	 int exponent;
    
    //if the first term contains negative coefficient, the first term is empty
    if (arr[0].isEmpty()) {
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i].contains("x^")) 
            {
                String str = arr[i].substring(0, arr[i].indexOf("x^"));
                String poly = arr[i].substring(arr[i].indexOf("x^") + 2);

                if(str.trim().length()>1){
                	coefficient = Integer.parseInt(str.trim());
                	exponent = Integer.parseInt(poly.trim());
            	}else{
            		coefficient = Integer.parseInt(str.trim());
            		exponent = Integer.parseInt(poly.trim());
            	}
                if (data.isEmpty()) 
                {
                    Term t= new Term(coefficient, exponent);
                    data = new DList<Term>();
                    data.addFirst(t);
                  System.out.println("hello");
                } 
                else 
                {
                	
                    Term t = new Term(coefficient, exponent);
                    DNode<Term> temp;
					try {
						temp = data.getFirst();
			            
						while(temp!=null && temp.getData().getDegree()>t.getDegree()){
	                    		temp=temp.getNext();
	                    }
						data.addBefore(t,temp);
					} catch (Exception e) {
						e.printStackTrace();
					}
                    
                }
            } 
            else {
	            if(arr[i].contains("x"))
	            {
	            	
	            	String str = arr[i].substring(0, arr[i].indexOf("x"));
	                String poly = 1+"";
	                
	                if(str.trim().length()>1){
	                	coefficient = Integer.parseInt(str.trim());
	                	exponent = Integer.parseInt(poly.trim());
	            	}else{
	            		coefficient=-1;
	            		exponent = Integer.parseInt(poly.trim());
	            	}                 
	                 
	                if (data == null) 
	                {
	                     Term t= new Term(coefficient, exponent);
	                     data = new DList<Term>();
	                     data.addFirst(t); 
	                 } 
	                 else 
	                 {
	                	 Term t = new Term(coefficient, exponent);
	                     DNode<Term> temp;
	 					try {
	 						temp = data.getFirst();
	 			            
	 						while(temp!=null && temp.getData().getDegree()>t.getDegree()){
	 	                    		temp=temp.getNext();
	 	                    }
	 						data.addBefore(t,temp);
	 					} catch (Exception e) {
	 						e.printStackTrace();
	 					}
	                 }
	            }else{
	            	coefficient = Integer.parseInt(arr[i].trim());
	                exponent = 0;
	                
	                if (data == null) 
	                {
	                    Term t= new Term(coefficient, exponent);
	                    data = new DList<Term>();
	                    data.addFirst(t);
	                } 
	                else 
	                {
	                    Term t = new Term(coefficient, exponent);
	                    data.addLast(t);
	                }
	            }
            }
        }
    } 
    else 
    {
        for (int i = 0; i < arr.length; i++) 
        {
            if (arr[i].contains("x^"))
            {
                String str = arr[i].substring(0, arr[i].indexOf("x^"));
                String poly = arr[i].substring(arr[i].indexOf("x^") + 2);

                if(str.trim().length()>0){
                	if(str.trim().equals("-")){
                		coefficient = -1;
                    	exponent = Integer.parseInt(poly.trim());
                	}else{
                		coefficient = Integer.parseInt(str.trim());
                    	exponent = Integer.parseInt(poly.trim());
                	}
                	
            	}else{
            		coefficient = 1;
            		exponent = Integer.parseInt(poly.trim());
            	}

                if (data.isEmpty()) 
                {
                    Term t= new Term(coefficient, exponent);
                    data = new DList<Term>();
                    data.addFirst(t);
                } 
                else 
                {
                    Term t = new Term(coefficient, exponent);
                    DNode<Term> temp;
					try {
						temp = data.getFirst();
			            
						while(temp!=null && temp.getData().getDegree()>t.getDegree()){
	                    		temp=temp.getNext();
	                    }
						data.addBefore(t,temp);
					} catch (Exception e) {
						e.printStackTrace();
					}
                }
            } 
            else{
            	if(arr[i].contains("x"))
            	{
            	
	            	String str = arr[i].substring(0, arr[i].indexOf("x"));
	                String poly = 1+"";
	
	                if(str.trim().length()>0){
	                	if(str.trim().equals("-")){
	                		coefficient = -1;	
	                		exponent = Integer.parseInt(poly.trim());
	                	}else{
	                		coefficient = Integer.parseInt(str.trim());
		                	exponent = Integer.parseInt(poly.trim());
	                	}
	                	
	            	}else{
	            		coefficient = 1;
	            		exponent = Integer.parseInt(poly.trim());
	            	} 
	                
	                if (data == null) 
	                {
	                     Term t= new Term(coefficient, exponent);
	                     data = new DList<Term>();
	                     data.addFirst(t);
	                 } 
	                 else 
	                 {
	                	 Term t = new Term(coefficient, exponent);
	                     DNode<Term> temp;
	 					try {
	 						temp = data.getFirst();
	 			            
	 						while(temp!=null && temp.getData().getDegree()>t.getDegree()){
	 	                    		temp=temp.getNext();
	 	                    }
	 						data.addBefore(t,temp);
	 					} catch (Exception e) {
	 						e.printStackTrace();
	 					}
	                 }
            	}
            	else 
            	{
	                coefficient = Integer.parseInt(arr[i].trim());
	                exponent = 0;
	
	                if (data == null) 
	                {
	                    Term t= new Term(coefficient, exponent);
	                    data = new DList<Term>();
	                    data.addFirst(t);
	                } 
	                else 
	                {
	                    Term t = new Term(coefficient, exponent);
	                    data.addLast(t);
	                }
            	}
            }
        }
    }
    data=removeDublicate(data);
       
    }
   public Polynomial() {
      super();
   }
   
   /****************
    * MAIN FUNCTION
    ****************/
    
   public static void main(String args[]) throws Exception {
      //Variables
      Scanner scnr = new Scanner(System.in);
      Polynomial p, q;
      String testInput = "";
      String testInput1 = "";
      //Custom test case
      if(scnr.hasNext()){
         testInput = scnr.nextLine();
         p = new Polynomial(testInput);
         
         testInput1 = scnr.nextLine();
         q = new Polynomial(testInput1);
         System.out.println("User Input\n***************************");
         Utility.run(p, q);
      }
      //Default test case
      else{
         p = new Polynomial(" X^5");
         q = new Polynomial("X^2 - X + 1");
         System.out.println("Default Input\n***************************");
         Utility.run(p, q);
      }
   }

@Override
public DList<Term> add(AbstractPolynomial p) {
	int degree;
	double coefficient;
	DList data1=this.data;
	DList data2 = new DList<Term>();
	try {
		DNode<Term> u=data1.getFirst();
		DNode<Term> v=p.data.getFirst();
		while(u.getNext()!=null && v.getNext()!=null){
			if(u.getData().degree==v.getData().degree){
				coefficient=u.getData().coefficient+v.getData().coefficient;
				degree=u.getData().degree;
				u=u.getNext();
				v=v.getNext();
			}else if(u.getData().degree>v.getData().degree){
				coefficient=u.getData().coefficient;
				degree=u.getData().degree;
				u=u.getNext();
			}else{
				coefficient=v.getData().coefficient;
				degree=v.getData().degree;
				v=v.getNext();
			}
			 Term t = new Term(coefficient, degree);
             data2.addLast(t);
		}
		while(u.getNext()!=null){
			coefficient=u.getData().coefficient;
			degree=u.getData().degree;
			u=u.getNext();
			Term t = new Term(coefficient, degree);
            data2.addLast(t);
		}
		while(v.getNext()!=null){
			coefficient=v.getData().coefficient;
			degree=v.getData().degree;
			v=v.getNext();
			Term t = new Term(coefficient, degree);
            data2.addLast(t);
		}
//		System.out.println("Sum = "+data2.toString());
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return removeDublicate(data2);
}

@Override
public DList<Term> subtract(AbstractPolynomial p) {
	int degree;
	double coefficient;
	DList data1=this.data;
	DList<Term> data2 = new DList<Term>();
	try {
		DNode<Term> u=data1.getFirst();
		DNode<Term> v=p.data.getFirst();
		while(u.getNext()!=null && v.getNext()!=null){
			if(u.getData().degree==v.getData().degree){
				coefficient=u.getData().coefficient-v.getData().coefficient;
				degree=u.getData().degree;
				u=u.getNext();
				v=v.getNext();
			}else if(u.getData().degree>v.getData().degree){
				coefficient=u.getData().coefficient;
				degree=u.getData().degree;
				u=u.getNext();
			}else{
				coefficient=v.getData().coefficient;
				degree=v.getData().degree;
				v=v.getNext();
			}
			 Term t = new Term(coefficient, degree);
             data2.addLast(t);
		}
		while(u.getNext()!=null){
			coefficient=u.getData().coefficient;
			degree=u.getData().degree;
			u=u.getNext();
			Term t = new Term(coefficient, degree);
            data2.addLast(t);
		}
		while(v.getNext()!=null){
			coefficient=v.getData().coefficient;
			degree=v.getData().degree;
			v=v.getNext();
			Term t = new Term(coefficient, degree);
            data2.addLast(t);
		}
//		System.out.println("Difference = "+data2.toString());
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return removeDublicate(data2);
}

@Override
public DList<Term> multiply(AbstractPolynomial p) {
	int degree;
	double coefficient;
	DList data1=this.data;
	data = new DList<Term>();
	
	try {
		DNode<Term> u=data1.getFirst();
		DNode<Term> v=p.data.getFirst();
		
		while(u.getNext()!=null){
			while(v.getNext()!=null){
		
				coefficient=u.getData().coefficient * v.getData().coefficient;
				degree=u.getData().degree+v.getData().degree;
				Term t = new Term(coefficient, degree);
				data.addLast(t);
				v=v.getNext();

			}
			v=p.data.getFirst();
			u=u.getNext();
		}
//		System.out.println("multiplecation="+data.toString());
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return removeDublicate(data);

}
public DList<Term> removeDublicate(DList<Term> list ){
	
	DNode<Term> ptr1;
	DNode<Term> ptr2;
	DNode<Term> dup;
	DList<Term> res=new DList<Term>();
	
	try {
		ptr1=list.getFirst();
	while (ptr1!=null && ptr1.getNext() != null){
		ptr2=ptr1;
	    while (ptr2.getNext()!=null && ptr2.getNext().getNext() != null) { 	    	
	    	 if (ptr1.getData().getDegree() == ptr2.getNext().getData().getDegree()) { 
	    		 
	    		  ptr1.getData().setCoefficient(ptr1.getData().getCoefficient()+ ptr2.getNext().getData().getCoefficient());  
	              dup = ptr2.getNext();  
	              ptr2.setNext( ptr2.getNext().getNext());  	              
	    	 }else{
	    		 ptr2=ptr2.getNext();
	    	 } 
	    }
	   res.addLast(ptr1.getData());
	   ptr1=ptr1.getNext();
	   
		
	}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return res;
}

public DList<Term> sortPoly(DList<Term> res){
	  try {
	    DNode<Term> prev = res.getFirst();
	    DNode<Term> current = res.getFirst().getNext();

	    while (current != null){
	        if (current.getData().getDegree() < prev.getData().getDegree()){
	            int temp = current.getData().getDegree();
	            current.getData().setDegree(prev.getData().getDegree());
//	            res.addAfter(d, v);
	            prev.getData().setDegree(temp);

	            double temp2 = current.getData().getCoefficient();
	            current.getData().setCoefficient(prev.getData().getCoefficient());
	            prev.getData().setCoefficient(temp2); 

	          
					prev =res.getFirst();
					current = res.getFirst().getNext();
				
	           
	        }
	    }
	        prev = prev.getNext();
	        current = current.getNext();
	    } catch (Exception e) {
			e.printStackTrace();
		}
	    
	    System.out.println("");
	    return null;
	
}


//2x^3 + 5x - x + 4
//2 + x^2 + 4x - 6 + 2 + 2x^2 + 4x^3 - x^2 + 7
}