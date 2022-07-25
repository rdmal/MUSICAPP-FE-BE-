import { Component, OnInit } from '@angular/core';

import { Track } from '../track.model';
import { MusicappService } from '../services/musicapp.service';
import { Subscription } from 'rxjs/internal/Subscription';
import { Observable } from 'rxjs/internal/Observable';

@Component({
  selector: 'app-list-music',
  templateUrl: './list-music.component.html',
  styleUrls: ['./list-music.component.css']
})
export class ListMusicComponent implements OnInit {

  musicList$ !: Observable<Track[]>;
  track  = new Track;
  notifyChange : Subscription = this.service.subjectNotifier.subscribe(notify => {
    this.musicList$ = this.service.getAllMusic();
  });


  constructor(private service: MusicappService) { }

  ngOnInit(): void {

 this.musicList$ = this.service.getAllMusic();

  }
  ngOnDestroy(): void {

    this.notifyChange .unsubscribe();
   
     }


  deleteMusic(music : Track) {
    //const deleteMusicBtn = document.getElementById("deleteMusic");
  //  if(deleteMusicBtn) {
      // deleteMusicBtn.click();
    //}

    //You will have access to music object
    if(confirm(`Are you sure you want to delete music id ${music.id}?`)) {
      //Send the music.id to service delete method
      this.service.deleteMusicById(music.id).subscribe(res=>{
       this.service.notifyChange();
       // console.log(res);
       // this.service.getAllMusic();
      });

    }
  }
  /*editMusic(musicId :number){
   this.service.getMusicById(musicId).subscribe(response => {
  this.track = response;
});
  }
updateMusic(){
 this.service.putMusicById(this.track.id, this.track ).subscribe(response => {
this.service.notifyChange();
const addMusicModalCloseBtn = document.getElementById("addMusicClose");
      if(addMusicModalCloseBtn) {
        addMusicModalCloseBtn.click();
}
 
});
}
 */
editMusic(musicId:number){
  //console.log(`my ${musicId}`);
     //if(confirm(`Are you sure you want to edit music id ${music.id}?`)) {

     //this. _router.navigate(['/addNewMusic',music.id]);    
     console.log(this.track.id);
       this.service.getMusicById(musicId).subscribe(response=>{
         this.track=response;
     //this.service.notifyChange(); 


   });
 }
 
         //this.service.updateMusic(music.id).subscribe(res=>{
     //this.service.notifyChange();
   
   updateMusic(){
     this.service.putMusic(this.track.id,this.track).subscribe(response=>{
     
     //refresh the list 
   this.service.notifyChange(); 
   //close modal
   const editMusicModalCloseBtn=document.getElementById("editMusicCloseModal");
   if(editMusicModalCloseBtn){
     editMusicModalCloseBtn.click();
   }
   });
 }

  

}
