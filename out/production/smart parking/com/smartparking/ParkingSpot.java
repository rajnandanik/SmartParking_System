����   A 9
      java/lang/Object <init> ()V	  	 
   com/smartparking/ParkingSpot id I	     floor	     type Lcom/smartparking/VehicleType;	     occupied Z	     
hasCharger	     reserved	     ! currentVehicle Lcom/smartparking/Vehicle; $(IILcom/smartparking/VehicleType;Z)V Code LineNumberTable LocalVariableTable this Lcom/smartparking/ParkingSpot; getId ()I getFloor getType  ()Lcom/smartparking/VehicleType; 
isOccupied ()Z 
isReserved assignVehicle (Lcom/smartparking/Vehicle;)V vehicle releaseVehicle ()Lcom/smartparking/Vehicle; temp getCurrentVehicle 
SourceFile ParkingSpot.java !                        !                  
   "  #   �     $*� *� *� *-� *� *� *� �    $   "       	          #  %   4    $ & '     $      $      $      $     ( )  #   /     *� �    $        %        & '    * )  #   /     *� �    $        %        & '    + ,  #   /     *� �    $        %        & '    - .  #   /     *� �    $       " %        & '     .  #   /     *� �    $       & %        & '    / .  #   /     *� �    $       * %        & '    0 1  #   G     *+� *� �    $       6  7 
 8 %        & '      2 !   3 4  #   Q     *� L*� *� +�    $       ;  < 
 =  > %        & '     5 !   6 4  #   /     *� �    $       B %        & '    7    8