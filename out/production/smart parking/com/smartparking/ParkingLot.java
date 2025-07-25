����   A
      java/lang/Object <init> ()V	  	 
   com/smartparking/ParkingLot totalRevenue I  java/util/ArrayList
  	     parkingHistory Ljava/util/List;	     spots
     initializeSpots  com/smartparking/ParkingSpot	      ! com/smartparking/VehicleType 
MOTORCYCLE Lcom/smartparking/VehicleType;
  #  $ $(IILcom/smartparking/VehicleType;Z)V & ' ( ) * java/util/List add (Ljava/lang/Object;)Z	  , - ! CAR	  / 0 ! BUS	  2 3 ! ELECTRIC_CAR
 5 6 7 8 9 com/smartparking/Vehicle 	getNumber ()Ljava/lang/String;
 5 ; < = isValidPlate (Ljava/lang/String;)Z	  ? @ A logger Ljava/util/logging/Logger;   C D E makeConcatWithConstants &(Ljava/lang/String;)Ljava/lang/String;
 G H I J K java/util/logging/Logger warning (Ljava/lang/String;)V & M N O iterator ()Ljava/util/Iterator; Q R S T U java/util/Iterator hasNext ()Z Q W X Y next ()Ljava/lang/Object;
  [ \ U 
isOccupied
  ^ _ U 
isReserved
  a b c getType  ()Lcom/smartparking/VehicleType;
 5 a
  f g U 
hasCharger
  i j k assignVehicle (Lcom/smartparking/Vehicle;)V
  m n o getId ()I
  q r o getFloor
 5 t u v getToken ()Ljava/util/UUID;
 x y z { | java/lang/String valueOf &(Ljava/lang/Object;)Ljava/lang/String;  ~ D  :(Ljava/lang/String;IILjava/lang/String;)Ljava/lang/String;
 G � � K info  C
  � � � getCurrentVehicle ()Lcom/smartparking/Vehicle;
 x � � * equals
  � � � releaseVehicle
 5 � � � getEntryTime ()Ljava/time/LocalDateTime;
 � � � � � java/time/LocalDateTime now
 � � � � � java/time/Duration between P(Ljava/time/temporal/Temporal;Ljava/time/temporal/Temporal;)Ljava/time/Duration;
 � � � � toHours ()J
 � � � � � java/lang/Math max (JJ)J
  � � � calculateFee "(Lcom/smartparking/VehicleType;J)I  � D � '(Ljava/lang/String;I)Ljava/lang/String;  C � !Vehicle not found in parking lot.	 � � � � � com/smartparking/ParkingLot$1 '$SwitchMap$com$smartparking$VehicleType [I
  � � o ordinal � )-- Real-Time Parking Spot Availability -- � 	, Charger �   � Occupied � Reserved � 	Available  � D � L(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; � -- Parking History --
 � � � � 9 java/lang/Class getName
 G � � � 	getLogger .(Ljava/lang/String;)Ljava/util/logging/Logger; 	Signature 0Ljava/util/List<Lcom/smartparking/ParkingSpot;>; $Ljava/util/List<Ljava/lang/String;>; Code LineNumberTable LocalVariableTable this Lcom/smartparking/ParkingLot; checkIn (Lcom/smartparking/Vehicle;)Z spot Lcom/smartparking/ParkingSpot; vehicle Lcom/smartparking/Vehicle; StackMapTable checkOut hours J fee record Ljava/lang/String; vehicleNumber type displayAvailableSpots getTotalRevenue displayHistory <clinit> 
SourceFile ParkingLot.java NestMembers BootstrapMethods � Invalid vehicle number:  � /Vehicle  parked at spot # (Floor: ) Token:  � %No spot available for vehicle type:  � Vehicle  exited. Fee: Rs.  � Checked out:  � Spot # (Floor ) [] -  
 D $java/lang/invoke/StringConcatFactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; InnerClasses %java/lang/invoke/MethodHandles$Lookup	 java/lang/invoke/MethodHandles Lookup !           �    �           �    �  @ A   	     �   b     $*� *� *� Y� � *� Y� � *� �    �         	 	 
     #  �       $ � �       �       �*� � Y� � "� % W*� � Y� � "� % W*� � Y� +� "� % W*� � Y� +� "� % W*� � Y� +� "� % W*� � Y� .� "� % W*� � Y� 1� "� % W*� � Y� 1� "� % W�    �   & 	      .  E  \  s  �  �  �  �       � � �   ! � �  �  &     �+� 4� :� � >+� 4� B  � F�*� � L M,� P � b,� V � N-� Z� N-� ]� G-� `+� d� <+� d� 1� -� e� ���-+� h� >+� 4-� l-� p+� s� w� }  � ������ >+� d� w� �  � F�    �   2     
      " 8 # Q $ e % j & � ' � ) � * � + �      8 R � �    � � �     � � �  �    � 	 Q� ? � $�  ! � K  �  J  	   �*� � L M,� P � �,� V � N-� Z� o-� �� 4+� �� a-� �:� �� �� �� �7
� �7*� d� �6*Y� `� � 4� �  :*� � % W� >� �  � ����z� >�� F�    �   :    /  0 2 1 8 2 H 3 P 4 ] 5 h 6 v 7 � 8 � 9 � ; � < � = �   H  8 X � �  H H � �  ] 3 �   v  � �   s � �    � � �     � � �  �    � 
 Q� ��   � �  �   �     B� �+� �.�      8             &   ,   2 �h� �(h� �<h� �h��    �       @ ( A . B 4 C : D @ E �        B � �     B � !    B � �  �    (  �   �  G     k� >�� �*� � L L+� P � R+� V � M� >,� l,� p,� `� w,� e� �� �,� Z� �� ,� ]� § ĺ �  � �����    �       J  K % L g M j N �     % B � �    k � �   �   � �  Q� 0   Q   G x�    Q   G x x�    Q   G x x�    Q   G x x�    Q   G x x x� 
  � o  �   /     *� �    �       Q �        � �    �   �   �     0� >ɶ �*� � L L+� P � +� V � xM� >,� ����    �       U  V % W , X / Y �     %  � �    0 � �   �    �  Q�   �   �   $      � ˸ г >�    �         �    � �     � �   &  �  � �  � �  � �  � �  � �  �     �    
 