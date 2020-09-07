console.log("testing");

import details from './moduleInfo.json';
import list from './moduleList.json';

var templateObj = {
  moduleCode: "",
  title: "",
  description: "",
  moduleCredit: "",
  department: "",
  faculty: "",
  workload: "",
  semesterData: {
    semester: "",
    examDate: "",
    examDuration: "",
  },
  preclusion: "",
  typeData: {
    su: "",
    sfs: "",
    ssgf: "",
    ism: "",
    fyp: "",
    year: "",
    grsu: "",
    lab: "",
    urop: "",
  },
  prerequisite: "",
  corequisite: "",
}

var fullDetails =  