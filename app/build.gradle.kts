plugins{id("com.android.application")}
android{
  namespace="com.muse.chat"
  compileSdk=34
  defaultConfig{applicationId="com.muse.chat";minSdk=24;targetSdk=34;versionCode=1;versionName="1.0"}
  buildTypes{release{isMinifyEnabled=false}}
}
