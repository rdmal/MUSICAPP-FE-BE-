import { Component, OnInit } from '@angular/core';
import { Track } from '../track.model';

@Component({
  selector: 'app-add-edit-music',
  templateUrl: './add-edit-music.component.html',
  styleUrls: ['./add-edit-music.component.css']
})
export class AddEditMusicComponent implements OnInit {
  track = new Track();
  service: any;
  constructor() { }

  ngOnInit(): void {
  }
  addNewMusic(){
    this.service.postMusic(this.track).subscribe(() =>{
      this.service.notifyChange();
   //close the modal
   const addMusicModalCloseBtn = document.getElementById("addMusicClose");
   
   
         if(addMusicModalCloseBtn) {
           addMusicModalCloseBtn.click();
   }
   //populate a success method
   const successAlert = document.getElementById("post-success-alert");
   if(successAlert){
   successAlert.style.display = "block";
   
   setTimeout(function() {
     successAlert.style.display = "none";
   
   }, 4000);
   
   }
   
    });

  }}
