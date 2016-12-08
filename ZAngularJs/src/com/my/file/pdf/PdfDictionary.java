/*
 *
 * This file is part of the iText (R) project.
 * Copyright (c) 1998-2016 iText Group NV
 * Authors: Bruno Lowagie, Paulo Soares, et al.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License version 3
 * as published by the Free Software Foundation with the addition of the
 * following permission added to Section 15 as permitted in Section 7(a):
 * FOR ANY PART OF THE COVERED WORK IN WHICH THE COPYRIGHT IS OWNED BY
 * ITEXT GROUP. ITEXT GROUP DISCLAIMS THE WARRANTY OF NON INFRINGEMENT
 * OF THIRD PARTY RIGHTS
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see http://www.gnu.org/licenses or write to
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA, 02110-1301 USA, or download the license from the following URL:
 * http://itextpdf.com/terms-of-use/
 *
 * The interactive user interfaces in modified source and object code versions
 * of this program must display Appropriate Legal Notices, as required under
 * Section 5 of the GNU Affero General Public License.
 *
 * In accordance with Section 7(b) of the GNU Affero General Public License,
 * a covered work must retain the producer line in every PDF that is created
 * or manipulated using iText.
 *
 * You can be released from the requirements of the license by purchasing
 * a commercial license. Buying such a license is mandatory as soon as you
 * develop commercial activities involving the iText software without
 * disclosing the source code of your own applications.
 * These activities include: offering paid services to customers as an ASP,
 * serving PDFs on the fly in a web application, shipping iText with a closed
 * source product.
 *
 * For more information, please contact iText Software Corp. at this
 * address: sales@itextpdf.com
 */
package com.my.file.pdf;


import java.util.LinkedHashMap;
import java.util.Set;

/**
 * <CODE>PdfDictionary</CODE> is the Pdf dictionary object.
 * <P>
 * A dictionary is an associative table containing pairs of objects.
 * The first element of each pair is called the <I>key</I> and the second
 * element is called the <I>value</I>.
 * Unlike dictionaries in the PostScript language, a key must be a
 * <CODE>PdfName</CODE>.
 * A value can be any kind of <CODE>PdfObject</CODE>, including a dictionary.
 * A dictionary is generally used to collect and tie together the attributes
 * of a complex object, with each key-value pair specifying the name and value
 * of an attribute.<BR>
 * A dictionary is represented by two left angle brackets (<<), followed by a
 * sequence of key-value pairs, followed by two right angle brackets (>>).<BR>
 * This object is described in the 'Portable Document Format Reference Manual
 * version 1.7' section 3.2.6 (page 59-60).
 * <P>
 *
 * @see		PdfObject
 * @see		PdfName
 * @see		BadPdfFormatException
 */
public class PdfDictionary extends PdfObject {

    // CONSTANTS

    /**
	  * @Fields serialVersionUID : TODO（用一句话描述这个变量表示什么）
	  */
	
	private static final long serialVersionUID = -8501366465751461073L;

	/** This is a possible type of dictionary */
    public static final PdfName FONT = PdfName.FONT;

    /** This is a possible type of dictionary */
    public static final PdfName OUTLINES = PdfName.OUTLINES;

    /** This is a possible type of dictionary */
    public static final PdfName PAGE = PdfName.PAGE;

    /** This is a possible type of dictionary */
    public static final PdfName PAGES = PdfName.PAGES;

    /** This is a possible type of dictionary */
    public static final PdfName CATALOG = PdfName.CATALOG;

    // CLASS VARIABLES

    /** This is the type of this dictionary */
    private PdfName dictionaryType = null;

    /** This is the hashmap that contains all the values and keys of the dictionary */
    protected LinkedHashMap<PdfName, PdfObject> hashMap;

    // CONSTRUCTORS

    /**
     * Constructs an empty <CODE>PdfDictionary</CODE>-object.
     */
    public PdfDictionary() {
        super(DICTIONARY);
        hashMap = new LinkedHashMap<PdfName, PdfObject>();
    }

    public PdfDictionary(int capacity) {
        super(DICTIONARY);
        hashMap = new LinkedHashMap<PdfName, PdfObject>(capacity);
    }




    /**
     * Copies all of the mappings from the specified <CODE>PdfDictionary</CODE>
     * to this <CODE>PdfDictionary</CODE>.
     *
     * These mappings will replace any mappings previously contained in this
     * <CODE>PdfDictionary</CODE>.
     *
     * @param dic The <CODE>PdfDictionary</CODE> with the mappings to be
     *   copied over
     */
    public void putAll(final PdfDictionary dic) {
        hashMap.putAll(dic.hashMap);
    }

    /**
     * Removes a <CODE>PdfObject</CODE> and its <VAR>key</VAR> from the
     * <CODE>PdfDictionary</CODE>.
     *
     * @param key a <CODE>PdfName</CODE>
     */
    public void remove(final PdfName key) {
        hashMap.remove(key);
    }

    /**
     * Removes all the <CODE>PdfObject</CODE>s and its <VAR>key</VAR>s from the
     * <CODE>PdfDictionary</CODE>.
     * @since 5.0.2
     */
    public void clear() {
        hashMap.clear();
    }

    /**
     * Returns the <CODE>PdfObject</CODE> associated to the specified
     * <VAR>key</VAR>.
     *
     * @param key a <CODE>PdfName</CODE>
     * @return the </CODE>PdfObject</CODE> previously associated to the
     *   <VAR>key</VAR>
     */
    public PdfObject get(final PdfName key) {
        return hashMap.get(key);
    }

    /**
     * Returns the <CODE>PdfObject</CODE> associated to the specified
     * <VAR>key</VAR>, resolving a possible indirect reference to a direct
     * object.
     *
     * This method will never return a <CODE>PdfIndirectReference</CODE>
     * object.
     *
     * @param key A key for the <CODE>PdfObject</CODE> to be returned
     * @return A direct <CODE>PdfObject</CODE> or <CODE>null</CODE>
     */
    public PdfObject getDirectObject(final PdfName key) {
    	// return PdfReader.getPdfObject(get(key));
    	return null;
    }

    /**
     * Get all keys that are set.
     *
     * @return <CODE>true</CODE> if it is, otherwise <CODE>false</CODE>.
     */
    public Set<PdfName> getKeys() {
        return hashMap.keySet();
    }

    /**
     * Returns the number of <VAR>key</VAR>-<VAR>value</VAR> mappings in this
     * <CODE>PdfDictionary</CODE>.
     *
     * @return the number of <VAR>key</VAR>-<VAR>value</VAR> mappings in this
     *   <CODE>PdfDictionary</CODE>.
     */
    public int size() {
        return hashMap.size();
    }

    /**
     * Returns <CODE>true</CODE> if this <CODE>PdfDictionary</CODE> contains a
     * mapping for the specified <VAR>key</VAR>.
     *
     * @return <CODE>true</CODE> if the key is set, otherwise <CODE>false</CODE>.
     */
    public boolean contains(final PdfName key) {
        return hashMap.containsKey(key);
    }

    // DICTIONARY TYPE METHODS

    /**
     * Checks if a <CODE>Dictionary</CODE> is of the type FONT.
     *
     * @return <CODE>true</CODE> if it is, otherwise <CODE>false</CODE>.
     */
    public boolean isFont() {
        return checkType(FONT);
    }

    /**
     * Checks if a <CODE>Dictionary</CODE> is of the type PAGE.
     *
     * @return <CODE>true</CODE> if it is, otherwise <CODE>false</CODE>.
     */
    public boolean isPage() {
        return checkType(PAGE);
    }

    /**
     * Checks if a <CODE>Dictionary</CODE> is of the type PAGES.
     *
     * @return <CODE>true</CODE> if it is, otherwise <CODE>false</CODE>.
     */
    public boolean isPages() {
        return checkType(PAGES);
    }

    /**
     * Checks if a <CODE>Dictionary</CODE> is of the type CATALOG.
     *
     * @return <CODE>true</CODE> if it is, otherwise <CODE>false</CODE>.
     */
    public boolean isCatalog() {
        return checkType(CATALOG);
    }

    /**
     * Checks if a <CODE>Dictionary</CODE> is of the type OUTLINES.
     *
     * @return <CODE>true</CODE> if it is, otherwise <CODE>false</CODE>.
     */
    public boolean isOutlineTree() {
        return checkType(OUTLINES);
    }
    
    /**
     * Checks the type of the dictionary.
     * @param type the type you're looking for
     * @return true if the type of the dictionary corresponds with the type you're looking for
     */
    public boolean checkType(PdfName type) {
    	if (type == null)
    		return false;
    	if (dictionaryType == null)
    		dictionaryType = getAsName(PdfName.TYPE);
    	return type.equals(dictionaryType);
    }

    // OTHER METHODS

    public void merge(final PdfDictionary other) {
        hashMap.putAll(other.hashMap);
    }

    public void mergeDifferent(final PdfDictionary other) {
        for (PdfName key : other.hashMap.keySet()) {
            if (!hashMap.containsKey(key))
                hashMap.put(key, other.hashMap.get(key));
        }
    }

     // DOWNCASTING GETTERS
     // @author Mark A Storer (2/17/06)

    /**
     * Returns a <CODE>PdfObject</CODE> as a <CODE>PdfDictionary</CODE>,
     * resolving indirect references.
     *
     * The object associated with the <CODE>PdfName</CODE> given is retrieved
     * and resolved to a direct object.
     * If it is a <CODE>PdfDictionary</CODE>, it is cast down and returned as
     * such. Otherwise <CODE>null</CODE> is returned.
     *
     * @param key A <CODE>PdfName</CODE>
     * @return the associated <CODE>PdfDictionary</CODE> object,
     *   or <CODE>null</CODE>
     */
    public PdfDictionary getAsDict(final PdfName key) {
        PdfDictionary dict = null;
        PdfObject orig = getDirectObject(key);
        if (orig != null && orig.isDictionary())
            dict = (PdfDictionary) orig;
        return dict;
    }


   
    /**
     * Returns a <CODE>PdfObject</CODE> as a <CODE>PdfString</CODE>,
     * resolving indirect references.
     *
     * The object associated with the <CODE>PdfName</CODE> given is retrieved
     * and resolved to a direct object.
     * If it is a <CODE>PdfString</CODE>, it is cast down and returned as such.
     * Otherwise <CODE>null</CODE> is returned.
     *
     * @param key A <CODE>PdfName</CODE>
     * @return the associated <CODE>PdfString</CODE> object,
     *   or <CODE>null</CODE>
     */
    public PdfString getAsString(final PdfName key) {
        PdfString string = null;
        PdfObject orig = getDirectObject(key);
        if (orig != null && orig.isString())
            string = (PdfString) orig;
        return string;
    }


    /**
     * Returns a <CODE>PdfObject</CODE> as a <CODE>PdfName</CODE>,
     * resolving indirect references.
     *
     * The object associated with the <CODE>PdfName</CODE> given is retrieved
     * and resolved to a direct object.
     * If it is a <CODE>PdfName</CODE>, it is cast down and returned as such.
     * Otherwise <CODE>null</CODE> is returned.
     *
     * @param key A <CODE>PdfName</CODE>
     * @return the associated <CODE>PdfName</CODE> object,
     *   or <CODE>null</CODE>
     */
    public PdfName getAsName(final PdfName key) {
        PdfName name = null;
        PdfObject orig = getDirectObject(key);
        if (orig != null && orig.isName())
            name = (PdfName) orig;
        return name;
    }


}
