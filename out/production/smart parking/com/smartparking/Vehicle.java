����   A <
      java/lang/Object <init> ()V	  	 
   com/smartparking/Vehicle number Ljava/lang/String;	     type Lcom/smartparking/VehicleType;
      java/time/LocalDateTime now ()Ljava/time/LocalDateTime;	     	entryTime Ljava/time/LocalDateTime;
       java/util/UUID 
randomUUID ()Ljava/util/UUID;	  " # $ token Ljava/util/UUID; & [A-Z]{2}\d{2}[A-Z]{2}\d{4}
 ( ) * + , java/lang/String matches (Ljava/lang/String;)Z 3(Ljava/lang/String;Lcom/smartparking/VehicleType;)V Code LineNumberTable LocalVariableTable this Lcom/smartparking/Vehicle; 	getNumber ()Ljava/lang/String; getType  ()Lcom/smartparking/VehicleType; getEntryTime getToken isValidPlate 
SourceFile Vehicle.java !                      # $      -  .   o     *� *+� *,� *� � *� � !�    /          	        0         1 2                3 4  .   /     *� �    /        0        1 2    5 6  .   /     *� �    /        0        1 2    7   .   /     *� �    /        0        1 2    8    .   /     *� !�    /         0        1 2   	 9 ,  .   1     *%� '�    /       $ 0             :    ;