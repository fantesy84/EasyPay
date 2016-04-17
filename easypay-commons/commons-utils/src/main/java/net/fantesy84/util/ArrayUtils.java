package net.fantesy84.util;

public abstract class ArrayUtils {
	public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class<?>[] {};
	public static final Object[] EMPTY_OBJECT_ARRAY = new Object[] {};
	public static final String[] EMPTY_STRING_ARRAY = new String[] {};
	public static final Integer[] EMPTY_INTEGER_ARRAY = new Integer[] {};
	public static final int[] EMPTY_INT_ARRAY = new int[] {};
	public static final Double[] EMPTY_DOUBLE_ARRAY = new Double[] {};
	public static final double[] EMPTY_RAW_DOUBLE_ARRAY = new double[] {};
	public static final Float[] EMPTY_FLOAT_ARRAY = new Float[] {};
	public static final float[] EMPTY_RAW_FLOAT_ARRAY = new float[] {};
	public static final Character[] EMPTY_CHARACTER_ARRAY = new Character[] {};
	public static final char[] EMPTY_CHAR_ARRAY = new char[] {};
	public static final Byte[] EMPTY_BYTE_ARRAY = new Byte[] {};
	public static final byte[] EMPTY_RAW_BYTE_ARRAY = new byte[] {};
	
	public static String array2String(String[] array){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			buffer.append(",").append(array[i]);
		}
		return buffer.toString().replaceFirst(",", "");
	}
	
	public static boolean isNullOrEmptyArray(Object[] args){
		if (args == null || args.length == 0) {
			return true;
		}
		return false;
	}
	
	public static void arraycopy(byte[] src, int src_position, byte[] dst, int dst_position, int length) {
        if (src_position < 0)
            throw new IllegalArgumentException("src_position was less than 0.  Actual value " + src_position);
        if (src_position >= src.length)
            throw new IllegalArgumentException( "src_position was greater than src array size.  Tried to write starting at position " + src_position + " but the array length is " + src.length );
        if (src_position + length > src.length)
            throw new IllegalArgumentException("src_position + length would overrun the src array.  Expected end at " + (src_position + length) + " actual end at " + src.length);
        if (dst_position < 0)
            throw new IllegalArgumentException("dst_position was less than 0.  Actual value " + dst_position);
        if (dst_position >= dst.length)
            throw new IllegalArgumentException( "dst_position was greater than dst array size.  Tried to write starting at position " + dst_position + " but the array length is " + dst.length );
        if (dst_position + length > dst.length)
            throw new IllegalArgumentException("dst_position + length would overrun the dst array.  Expected end at " + (dst_position + length) + " actual end at " + dst.length);

        System.arraycopy( src, src_position, dst, dst_position, length);
    }
	
	/**
     * Moves a number of entries in an array to another point in the array,
     *  shifting those inbetween as required.
     * @param array The array to alter
     * @param moveFrom The (0 based) index of the first entry to move
     * @param moveTo The (0 based) index of the positition to move to
     * @param numToMove The number of entries to move
     */
    public static void arrayMoveWithin(Object[] array, int moveFrom, int moveTo, int numToMove) {
    	if(numToMove <= 0) { 
    		return; 
    	}
    	if(moveFrom == moveTo) { 
    		return; 
    	}
    	if(moveFrom < 0 || moveFrom >= array.length) {
    		throw new IllegalArgumentException("The moveFrom must be a valid array index");
    	}
    	if(moveTo < 0 || moveTo >= array.length) {
    		throw new IllegalArgumentException("The moveTo must be a valid array index");
    	}
    	if(moveFrom+numToMove > array.length) {
    		throw new IllegalArgumentException("Asked to move more entries than the array has");
    	}
    	if(moveTo+numToMove > array.length) {
    		throw new IllegalArgumentException("Asked to move to a position that doesn't have enough space");
    	}
    	
    	// Grab the bit to move 
    	Object[] toMove = new Object[numToMove];
    	System.arraycopy(array, moveFrom, toMove, 0, numToMove);
    	
    	// Grab the bit to be shifted
    	Object[] toShift;
    	int shiftTo;
    	if(moveFrom > moveTo) {
    		// Moving to an earlier point in the array
    		// Grab everything between the two points
    		toShift = new Object[(moveFrom-moveTo)];
    		System.arraycopy(array, moveTo, toShift, 0, toShift.length);
    		shiftTo = moveTo + numToMove;
    	} else {
    		// Moving to a later point in the array
    		// Grab everything from after the toMove block, to the new point
    		toShift = new Object[(moveTo-moveFrom)];
    		System.arraycopy(array, moveFrom+numToMove, toShift, 0, toShift.length);
    		shiftTo = moveFrom;
    	}
    	
    	// Copy the moved block to its new location
    	System.arraycopy(toMove, 0, array, moveTo, toMove.length);
    	
    	// And copy the shifted block to the shifted location
    	System.arraycopy(toShift, 0, array, shiftTo, toShift.length);
    }
}
