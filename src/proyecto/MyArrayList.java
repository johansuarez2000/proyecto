/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.*;


/**
 *
 * @author Usuario
 * @param <T>
 */
public class MyArrayList<T extends Comparable>  {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private T [ ] items;
    public MyArrayList( )
	{ 
            doClear( ); 
        }

    public void clear( )
	{ 
            doClear( );
        }

    private void doClear( ){
	 size = 0; 
         ensureCapacity( DEFAULT_CAPACITY );
        }

    public int size( ){
    return size;
    }
    public boolean isEmpty( ){
	return size( ) == 0; 
    }
    public void trimToSize( ){
        ensureCapacity( size( ) );
    }

    public T get(int idx){
    if( idx < 0 || idx >= size( ) ){
    throw new ArrayIndexOutOfBoundsException( );
    }
    return items[idx];
   }
    public T set( int idx,T newVal ){	
    if( idx < 0 || idx >= size( ) ){
      throw new ArrayIndexOutOfBoundsException( );
    }
    T old = items[idx];
    items[idx] = newVal;
    return old;
    }
    public void ensureCapacity( int newCapacity ){
    if( newCapacity < size ){
	return;
    }
    T[ ] old = items;
    items = (T[]) new Comparable [newCapacity];
    for( int i = 0; i < size( ); i++ ){
	items[i] = old[ i ];
    }
}
    public boolean add(T x ){
    add( size( ), x );
    return true;
    }
    public void add( int idx, T x )
	{
	if( items.length == size( ) )
	ensureCapacity( size( ) * 2+1 );
	for( int i = size; i >idx; i-- ){
	items[i] = items[i-1];
        }
	items[idx] = x;
	size++;
      	}
 
   public T remove( int idx ){
	T removedItem = items[ idx ];
	for( int i = idx; i < size( ) - 1; i++ ){
	items[ i ] = items[ i + 1 ];
        }
	size--;
	return removedItem;
	}
   public int find( T x){     
       int y = -2;
       for (int i = 0; i < size; i++) {
           if (x.compareTo(items[i])==0){
               y=i;
               i=size;
           }
           }     
     if(y==-2){
         System.out.println(x.getClass()+ " no encontrado");
     }  
     return y;
   }
   public void sort( Comparator<T> c )
   {
      Arrays.sort(items, 0, size, c);
   }

}
