import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Observable } from 'rxjs';
import { Track } from '../track.model';

@Injectable({
  providedIn: 'root'
})
export class MusicappService {
  readonly baseApiUrl= "http://localhost:8080/api";
  
  subjectNotifier: Subject<null> = new Subject<null>();

  
  constructor(private http: HttpClient) { }
    getAllMusic() : Observable<Track[]> {
    
      return this.http.get<Track[]>(this.baseApiUrl + "/musicapp");
    }
    postMusic(data : Track){

      return  this.http.post<Track[]>(this.baseApiUrl +"/musicapp",data);
    }
  
deleteMusicById(id :number){

  return this.http.delete<Track[]>(this.baseApiUrl  + '/musicapp/' +  id) ;

}

/*getMusicById(Id : number):Observable<Track>
{
  return this.http.get<Track>(this.baseApiUrl +`/musicapp/${Id}`)
}
putMusicById(Id : number , data: Track){ //update
  return  this.http.put(this.baseApiUrl + `/playlist/track/${Id}` , data);
}
*/
getMusicById(id:number): Observable<Track>{
  //console.log(`by ${id}`);
   return this.http.get<Track>(this.baseApiUrl+`/musicapp/${id}`);

 }
 putMusic(id:number,data:Track){

   //this.http.post<Track[]>(this.baseApiUrl+"/playlist/track",+id);
   console.log(id);
   return this.http.put(this.baseApiUrl + `/musicapp/${id}`,data);
 }


notifyChange(){
  this.subjectNotifier.next(null);
}

  
}
