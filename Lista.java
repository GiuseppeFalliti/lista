public class Lista<T>{
    private Object[] list;
    private int count;

    public Lista() {
        list = new Object[1];
        count = 0;
    }

    public void add(T obj) {
        
        if (count >= list.length) { 
            
            Object[] newList = new Object[list.length * 2];
            System.arraycopy(list, 0, newList, 0, list.length);//metodo copiare il contenuto di un array in un altro array
            list = newList;
        }

        list[count] = obj;
        count++;
    }


    public void remove(int index,T obj){
        if (index>=0 && index<list.length){
            list[index]=null;            
        }
       count--;
    }

    public void clear(){
        for (int i = 0; i< list.length; i++) {
            list[i]=null;
            
        }
        count = 0;
    }
    public int size(){
        return list.length;
    }

    public Object get(int index){
        return list[index];
    }



}