import java.util.*;

class Solution {
    
    static Map<Long, Long> emptyRooms = new HashMap<>();
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        for (int i=0; i<room_number.length; i++) {
            long cur = room_number[i];
            
            answer[i] = findRoom(cur);
        }
          
        return answer;
    }
    
    private static long findRoom(long roomNumber) {
        if (!emptyRooms.containsKey(roomNumber)) {
            emptyRooms.put(roomNumber, roomNumber+1);
            return roomNumber;
        }
        
        long emptyRoom = findRoom(emptyRooms.get(roomNumber));
        
        emptyRooms.put(roomNumber, emptyRoom);
        
        return emptyRoom;
    }
}