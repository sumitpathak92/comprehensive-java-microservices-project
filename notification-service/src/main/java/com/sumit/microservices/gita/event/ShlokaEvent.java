/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.sumit.microservices.gita.event;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class ShlokaEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3488078991777293424L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ShlokaEvent\",\"namespace\":\"com.sumit.microservices.gita.event\",\"fields\":[{\"name\":\"chapter\",\"type\":\"int\"},{\"name\":\"verse\",\"type\":\"int\"},{\"name\":\"shloka\",\"type\":\"string\"},{\"name\":\"englishText\",\"type\":\"string\"},{\"name\":\"translation\",\"type\":\"string\"},{\"name\":\"commentary\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ShlokaEvent> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ShlokaEvent> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ShlokaEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ShlokaEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ShlokaEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ShlokaEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ShlokaEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ShlokaEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ShlokaEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private int chapter;
  private int verse;
  private java.lang.CharSequence shloka;
  private java.lang.CharSequence englishText;
  private java.lang.CharSequence translation;
  private java.lang.CharSequence commentary;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ShlokaEvent() {}

  /**
   * All-args constructor.
   * @param chapter The new value for chapter
   * @param verse The new value for verse
   * @param shloka The new value for shloka
   * @param englishText The new value for englishText
   * @param translation The new value for translation
   * @param commentary The new value for commentary
   */
  public ShlokaEvent(java.lang.Integer chapter, java.lang.Integer verse, java.lang.CharSequence shloka, java.lang.CharSequence englishText, java.lang.CharSequence translation, java.lang.CharSequence commentary) {
    this.chapter = chapter;
    this.verse = verse;
    this.shloka = shloka;
    this.englishText = englishText;
    this.translation = translation;
    this.commentary = commentary;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return chapter;
    case 1: return verse;
    case 2: return shloka;
    case 3: return englishText;
    case 4: return translation;
    case 5: return commentary;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: chapter = (java.lang.Integer)value$; break;
    case 1: verse = (java.lang.Integer)value$; break;
    case 2: shloka = (java.lang.CharSequence)value$; break;
    case 3: englishText = (java.lang.CharSequence)value$; break;
    case 4: translation = (java.lang.CharSequence)value$; break;
    case 5: commentary = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'chapter' field.
   * @return The value of the 'chapter' field.
   */
  public int getChapter() {
    return chapter;
  }


  /**
   * Sets the value of the 'chapter' field.
   * @param value the value to set.
   */
  public void setChapter(int value) {
    this.chapter = value;
  }

  /**
   * Gets the value of the 'verse' field.
   * @return The value of the 'verse' field.
   */
  public int getVerse() {
    return verse;
  }


  /**
   * Sets the value of the 'verse' field.
   * @param value the value to set.
   */
  public void setVerse(int value) {
    this.verse = value;
  }

  /**
   * Gets the value of the 'shloka' field.
   * @return The value of the 'shloka' field.
   */
  public java.lang.CharSequence getShloka() {
    return shloka;
  }


  /**
   * Sets the value of the 'shloka' field.
   * @param value the value to set.
   */
  public void setShloka(java.lang.CharSequence value) {
    this.shloka = value;
  }

  /**
   * Gets the value of the 'englishText' field.
   * @return The value of the 'englishText' field.
   */
  public java.lang.CharSequence getEnglishText() {
    return englishText;
  }


  /**
   * Sets the value of the 'englishText' field.
   * @param value the value to set.
   */
  public void setEnglishText(java.lang.CharSequence value) {
    this.englishText = value;
  }

  /**
   * Gets the value of the 'translation' field.
   * @return The value of the 'translation' field.
   */
  public java.lang.CharSequence getTranslation() {
    return translation;
  }


  /**
   * Sets the value of the 'translation' field.
   * @param value the value to set.
   */
  public void setTranslation(java.lang.CharSequence value) {
    this.translation = value;
  }

  /**
   * Gets the value of the 'commentary' field.
   * @return The value of the 'commentary' field.
   */
  public java.lang.CharSequence getCommentary() {
    return commentary;
  }


  /**
   * Sets the value of the 'commentary' field.
   * @param value the value to set.
   */
  public void setCommentary(java.lang.CharSequence value) {
    this.commentary = value;
  }

  /**
   * Creates a new ShlokaEvent RecordBuilder.
   * @return A new ShlokaEvent RecordBuilder
   */
  public static com.sumit.microservices.gita.event.ShlokaEvent.Builder newBuilder() {
    return new com.sumit.microservices.gita.event.ShlokaEvent.Builder();
  }

  /**
   * Creates a new ShlokaEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ShlokaEvent RecordBuilder
   */
  public static com.sumit.microservices.gita.event.ShlokaEvent.Builder newBuilder(com.sumit.microservices.gita.event.ShlokaEvent.Builder other) {
    if (other == null) {
      return new com.sumit.microservices.gita.event.ShlokaEvent.Builder();
    } else {
      return new com.sumit.microservices.gita.event.ShlokaEvent.Builder(other);
    }
  }

  /**
   * Creates a new ShlokaEvent RecordBuilder by copying an existing ShlokaEvent instance.
   * @param other The existing instance to copy.
   * @return A new ShlokaEvent RecordBuilder
   */
  public static com.sumit.microservices.gita.event.ShlokaEvent.Builder newBuilder(com.sumit.microservices.gita.event.ShlokaEvent other) {
    if (other == null) {
      return new com.sumit.microservices.gita.event.ShlokaEvent.Builder();
    } else {
      return new com.sumit.microservices.gita.event.ShlokaEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for ShlokaEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ShlokaEvent>
    implements org.apache.avro.data.RecordBuilder<ShlokaEvent> {

    private int chapter;
    private int verse;
    private java.lang.CharSequence shloka;
    private java.lang.CharSequence englishText;
    private java.lang.CharSequence translation;
    private java.lang.CharSequence commentary;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.sumit.microservices.gita.event.ShlokaEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.chapter)) {
        this.chapter = data().deepCopy(fields()[0].schema(), other.chapter);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.verse)) {
        this.verse = data().deepCopy(fields()[1].schema(), other.verse);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.shloka)) {
        this.shloka = data().deepCopy(fields()[2].schema(), other.shloka);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.englishText)) {
        this.englishText = data().deepCopy(fields()[3].schema(), other.englishText);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.translation)) {
        this.translation = data().deepCopy(fields()[4].schema(), other.translation);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.commentary)) {
        this.commentary = data().deepCopy(fields()[5].schema(), other.commentary);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
    }

    /**
     * Creates a Builder by copying an existing ShlokaEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.sumit.microservices.gita.event.ShlokaEvent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.chapter)) {
        this.chapter = data().deepCopy(fields()[0].schema(), other.chapter);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.verse)) {
        this.verse = data().deepCopy(fields()[1].schema(), other.verse);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.shloka)) {
        this.shloka = data().deepCopy(fields()[2].schema(), other.shloka);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.englishText)) {
        this.englishText = data().deepCopy(fields()[3].schema(), other.englishText);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.translation)) {
        this.translation = data().deepCopy(fields()[4].schema(), other.translation);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.commentary)) {
        this.commentary = data().deepCopy(fields()[5].schema(), other.commentary);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'chapter' field.
      * @return The value.
      */
    public int getChapter() {
      return chapter;
    }


    /**
      * Sets the value of the 'chapter' field.
      * @param value The value of 'chapter'.
      * @return This builder.
      */
    public com.sumit.microservices.gita.event.ShlokaEvent.Builder setChapter(int value) {
      validate(fields()[0], value);
      this.chapter = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'chapter' field has been set.
      * @return True if the 'chapter' field has been set, false otherwise.
      */
    public boolean hasChapter() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'chapter' field.
      * @return This builder.
      */
    public com.sumit.microservices.gita.event.ShlokaEvent.Builder clearChapter() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'verse' field.
      * @return The value.
      */
    public int getVerse() {
      return verse;
    }


    /**
      * Sets the value of the 'verse' field.
      * @param value The value of 'verse'.
      * @return This builder.
      */
    public com.sumit.microservices.gita.event.ShlokaEvent.Builder setVerse(int value) {
      validate(fields()[1], value);
      this.verse = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'verse' field has been set.
      * @return True if the 'verse' field has been set, false otherwise.
      */
    public boolean hasVerse() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'verse' field.
      * @return This builder.
      */
    public com.sumit.microservices.gita.event.ShlokaEvent.Builder clearVerse() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'shloka' field.
      * @return The value.
      */
    public java.lang.CharSequence getShloka() {
      return shloka;
    }


    /**
      * Sets the value of the 'shloka' field.
      * @param value The value of 'shloka'.
      * @return This builder.
      */
    public com.sumit.microservices.gita.event.ShlokaEvent.Builder setShloka(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.shloka = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'shloka' field has been set.
      * @return True if the 'shloka' field has been set, false otherwise.
      */
    public boolean hasShloka() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'shloka' field.
      * @return This builder.
      */
    public com.sumit.microservices.gita.event.ShlokaEvent.Builder clearShloka() {
      shloka = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'englishText' field.
      * @return The value.
      */
    public java.lang.CharSequence getEnglishText() {
      return englishText;
    }


    /**
      * Sets the value of the 'englishText' field.
      * @param value The value of 'englishText'.
      * @return This builder.
      */
    public com.sumit.microservices.gita.event.ShlokaEvent.Builder setEnglishText(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.englishText = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'englishText' field has been set.
      * @return True if the 'englishText' field has been set, false otherwise.
      */
    public boolean hasEnglishText() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'englishText' field.
      * @return This builder.
      */
    public com.sumit.microservices.gita.event.ShlokaEvent.Builder clearEnglishText() {
      englishText = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'translation' field.
      * @return The value.
      */
    public java.lang.CharSequence getTranslation() {
      return translation;
    }


    /**
      * Sets the value of the 'translation' field.
      * @param value The value of 'translation'.
      * @return This builder.
      */
    public com.sumit.microservices.gita.event.ShlokaEvent.Builder setTranslation(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.translation = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'translation' field has been set.
      * @return True if the 'translation' field has been set, false otherwise.
      */
    public boolean hasTranslation() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'translation' field.
      * @return This builder.
      */
    public com.sumit.microservices.gita.event.ShlokaEvent.Builder clearTranslation() {
      translation = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'commentary' field.
      * @return The value.
      */
    public java.lang.CharSequence getCommentary() {
      return commentary;
    }


    /**
      * Sets the value of the 'commentary' field.
      * @param value The value of 'commentary'.
      * @return This builder.
      */
    public com.sumit.microservices.gita.event.ShlokaEvent.Builder setCommentary(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.commentary = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'commentary' field has been set.
      * @return True if the 'commentary' field has been set, false otherwise.
      */
    public boolean hasCommentary() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'commentary' field.
      * @return This builder.
      */
    public com.sumit.microservices.gita.event.ShlokaEvent.Builder clearCommentary() {
      commentary = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ShlokaEvent build() {
      try {
        ShlokaEvent record = new ShlokaEvent();
        record.chapter = fieldSetFlags()[0] ? this.chapter : (java.lang.Integer) defaultValue(fields()[0]);
        record.verse = fieldSetFlags()[1] ? this.verse : (java.lang.Integer) defaultValue(fields()[1]);
        record.shloka = fieldSetFlags()[2] ? this.shloka : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.englishText = fieldSetFlags()[3] ? this.englishText : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.translation = fieldSetFlags()[4] ? this.translation : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.commentary = fieldSetFlags()[5] ? this.commentary : (java.lang.CharSequence) defaultValue(fields()[5]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ShlokaEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<ShlokaEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ShlokaEvent>
    READER$ = (org.apache.avro.io.DatumReader<ShlokaEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeInt(this.chapter);

    out.writeInt(this.verse);

    out.writeString(this.shloka);

    out.writeString(this.englishText);

    out.writeString(this.translation);

    out.writeString(this.commentary);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.chapter = in.readInt();

      this.verse = in.readInt();

      this.shloka = in.readString(this.shloka instanceof Utf8 ? (Utf8)this.shloka : null);

      this.englishText = in.readString(this.englishText instanceof Utf8 ? (Utf8)this.englishText : null);

      this.translation = in.readString(this.translation instanceof Utf8 ? (Utf8)this.translation : null);

      this.commentary = in.readString(this.commentary instanceof Utf8 ? (Utf8)this.commentary : null);

    } else {
      for (int i = 0; i < 6; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.chapter = in.readInt();
          break;

        case 1:
          this.verse = in.readInt();
          break;

        case 2:
          this.shloka = in.readString(this.shloka instanceof Utf8 ? (Utf8)this.shloka : null);
          break;

        case 3:
          this.englishText = in.readString(this.englishText instanceof Utf8 ? (Utf8)this.englishText : null);
          break;

        case 4:
          this.translation = in.readString(this.translation instanceof Utf8 ? (Utf8)this.translation : null);
          break;

        case 5:
          this.commentary = in.readString(this.commentary instanceof Utf8 ? (Utf8)this.commentary : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










