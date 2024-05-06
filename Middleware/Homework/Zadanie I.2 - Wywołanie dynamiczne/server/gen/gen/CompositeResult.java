// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: composite.proto

// Protobuf Java Version: 3.25.0
package gen;

/**
 * Protobuf type {@code calculator.CompositeResult}
 */
public final class CompositeResult extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:calculator.CompositeResult)
    CompositeResultOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CompositeResult.newBuilder() to construct.
  private CompositeResult(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CompositeResult() {
    composites_ = emptyLongList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CompositeResult();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return gen.CompositeProto.internal_static_calculator_CompositeResult_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return gen.CompositeProto.internal_static_calculator_CompositeResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            gen.CompositeResult.class, gen.CompositeResult.Builder.class);
  }

  public static final int COMPOSITES_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private com.google.protobuf.Internal.LongList composites_ =
      emptyLongList();
  /**
   * <code>repeated int64 composites = 1;</code>
   * @return A list containing the composites.
   */
  @java.lang.Override
  public java.util.List<java.lang.Long>
      getCompositesList() {
    return composites_;
  }
  /**
   * <code>repeated int64 composites = 1;</code>
   * @return The count of composites.
   */
  public int getCompositesCount() {
    return composites_.size();
  }
  /**
   * <code>repeated int64 composites = 1;</code>
   * @param index The index of the element to return.
   * @return The composites at the given index.
   */
  public long getComposites(int index) {
    return composites_.getLong(index);
  }
  private int compositesMemoizedSerializedSize = -1;

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (getCompositesList().size() > 0) {
      output.writeUInt32NoTag(10);
      output.writeUInt32NoTag(compositesMemoizedSerializedSize);
    }
    for (int i = 0; i < composites_.size(); i++) {
      output.writeInt64NoTag(composites_.getLong(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < composites_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt64SizeNoTag(composites_.getLong(i));
      }
      size += dataSize;
      if (!getCompositesList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      compositesMemoizedSerializedSize = dataSize;
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof gen.CompositeResult)) {
      return super.equals(obj);
    }
    gen.CompositeResult other = (gen.CompositeResult) obj;

    if (!getCompositesList()
        .equals(other.getCompositesList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getCompositesCount() > 0) {
      hash = (37 * hash) + COMPOSITES_FIELD_NUMBER;
      hash = (53 * hash) + getCompositesList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static gen.CompositeResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static gen.CompositeResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static gen.CompositeResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static gen.CompositeResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static gen.CompositeResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static gen.CompositeResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static gen.CompositeResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static gen.CompositeResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static gen.CompositeResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static gen.CompositeResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static gen.CompositeResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static gen.CompositeResult parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(gen.CompositeResult prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code calculator.CompositeResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:calculator.CompositeResult)
      gen.CompositeResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return gen.CompositeProto.internal_static_calculator_CompositeResult_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return gen.CompositeProto.internal_static_calculator_CompositeResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              gen.CompositeResult.class, gen.CompositeResult.Builder.class);
    }

    // Construct using gen.CompositeResult.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      composites_ = emptyLongList();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return gen.CompositeProto.internal_static_calculator_CompositeResult_descriptor;
    }

    @java.lang.Override
    public gen.CompositeResult getDefaultInstanceForType() {
      return gen.CompositeResult.getDefaultInstance();
    }

    @java.lang.Override
    public gen.CompositeResult build() {
      gen.CompositeResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public gen.CompositeResult buildPartial() {
      gen.CompositeResult result = new gen.CompositeResult(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(gen.CompositeResult result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        composites_.makeImmutable();
        result.composites_ = composites_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof gen.CompositeResult) {
        return mergeFrom((gen.CompositeResult)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(gen.CompositeResult other) {
      if (other == gen.CompositeResult.getDefaultInstance()) return this;
      if (!other.composites_.isEmpty()) {
        if (composites_.isEmpty()) {
          composites_ = other.composites_;
          composites_.makeImmutable();
          bitField0_ |= 0x00000001;
        } else {
          ensureCompositesIsMutable();
          composites_.addAll(other.composites_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              long v = input.readInt64();
              ensureCompositesIsMutable();
              composites_.addLong(v);
              break;
            } // case 8
            case 10: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              ensureCompositesIsMutable();
              while (input.getBytesUntilLimit() > 0) {
                composites_.addLong(input.readInt64());
              }
              input.popLimit(limit);
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.Internal.LongList composites_ = emptyLongList();
    private void ensureCompositesIsMutable() {
      if (!composites_.isModifiable()) {
        composites_ = makeMutableCopy(composites_);
      }
      bitField0_ |= 0x00000001;
    }
    /**
     * <code>repeated int64 composites = 1;</code>
     * @return A list containing the composites.
     */
    public java.util.List<java.lang.Long>
        getCompositesList() {
      composites_.makeImmutable();
      return composites_;
    }
    /**
     * <code>repeated int64 composites = 1;</code>
     * @return The count of composites.
     */
    public int getCompositesCount() {
      return composites_.size();
    }
    /**
     * <code>repeated int64 composites = 1;</code>
     * @param index The index of the element to return.
     * @return The composites at the given index.
     */
    public long getComposites(int index) {
      return composites_.getLong(index);
    }
    /**
     * <code>repeated int64 composites = 1;</code>
     * @param index The index to set the value at.
     * @param value The composites to set.
     * @return This builder for chaining.
     */
    public Builder setComposites(
        int index, long value) {

      ensureCompositesIsMutable();
      composites_.setLong(index, value);
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 composites = 1;</code>
     * @param value The composites to add.
     * @return This builder for chaining.
     */
    public Builder addComposites(long value) {

      ensureCompositesIsMutable();
      composites_.addLong(value);
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 composites = 1;</code>
     * @param values The composites to add.
     * @return This builder for chaining.
     */
    public Builder addAllComposites(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensureCompositesIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, composites_);
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 composites = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearComposites() {
      composites_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:calculator.CompositeResult)
  }

  // @@protoc_insertion_point(class_scope:calculator.CompositeResult)
  private static final gen.CompositeResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new gen.CompositeResult();
  }

  public static gen.CompositeResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CompositeResult>
      PARSER = new com.google.protobuf.AbstractParser<CompositeResult>() {
    @java.lang.Override
    public CompositeResult parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<CompositeResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CompositeResult> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public gen.CompositeResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

