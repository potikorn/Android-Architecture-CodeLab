package android.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
    addMapper(new com.example.android.sunshine.DataBinderMapperImpl());
  }
}
