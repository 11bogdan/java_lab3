
javac AudioTreatmentLib\src\audiotreatmentlib\Calculations.java
javac -cp "AudioTreatmentLib\src" AudioTreatment\src\audiotreatment\AudioTreatment.java
java -cp "AudioTreatmentLib\src;AudioTreatment\src" audiotreatment.AudioTreatment $args[0]